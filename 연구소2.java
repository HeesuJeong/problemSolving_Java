import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소2 {
	// 0빈칸 1벽 2바이러스후보자리
	// -1벽 -2 바이러스 둔 자리 0 이동 가능 자리
	static int N;
	static int M;
	static Scanner sc = new Scanner(System.in);
	static int[][] map;
	final static int[] dx = { -1, 1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };
	static Queue<Point> q = new LinkedList<Point>();
	static Queue<Point> newQ = new LinkedList<Point>();
	final static int defaultMAX = 1000000;
	static int resul = defaultMAX;
	static int cnt;
	static int[][] temp;

	static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					temp[i][j] = 0;
				} else {
					if (map[i][j] == -2) {
						q.add(new Point(i, j));
					}
					temp[i][j] = map[i][j];
				}
			}
		}
	}

	static boolean inMap(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static void BFS() {
		while (!q.isEmpty()) {
			while (!q.isEmpty()) {
				Point n = q.poll();
				temp[n.x][n.y] = cnt;
				for (int i = 0; i < 4; i++) {
					int nx = n.x + dx[i];
					int ny = n.y + dy[i];
					if (inMap(nx, ny) && temp[nx][ny] == 0) {
						temp[nx][ny] = cnt;
						newQ.add(new Point(nx, ny));
					}
				}

			}
			while (!newQ.isEmpty()) {
				q.add(newQ.poll());
			}
			cnt++;
		}
	}

	static void spread() {
		copy();

		cnt = 1;
		BFS();
		System.out.println("==============");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
		
		
		int notzero = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (temp[i][j] != 0)
					notzero++;
			}
		}
		if (notzero == N * N) {
			resul = Math.min(resul, cnt - 2);
		}
	}

	// 바이러스두기
	static void virus(int x,int c) {
		if (c == M) {
			spread();
			return;
		}
		for (int i = x; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					map[i][j] = -2;
					virus(i,c + 1);
					map[i][j] = 2;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int input = sc.nextInt();
				if (input == 1)
					input = -1; // 벽은 -1로 표현
				map[i][j] = input;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					map[i][j] = -2; // 바이러스 둔 위치 표시
					virus(i,1);
					map[i][j] = 2;
				}
			}
		}

		if (resul == defaultMAX)
			resul = -1;
		System.out.println(resul);
	}

}