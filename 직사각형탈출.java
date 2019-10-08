import java.util.LinkedList;
import java.util.Scanner;

public class 직사각형탈출 {

	// 직사각형 크기
	static int N;
	static int M;
	// 배열
	static int[][] map;
	static boolean[][] visited;
	// 격자판 크기
	static int H;
	static int W;
	// 시작좌표
	static int Sr;
	static int Sc;
	// 도착좌표
	static int Fr;
	static int Fc;
	static Scanner sc = new Scanner(System.in);

	static LinkedList<Point> li;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int resul;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		li = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				int input = sc.nextInt();
				map[i][j] = input;
			}
		}
		// 직사각형 크기 H*W
		H = sc.nextInt();
		W = sc.nextInt();
		Sr = sc.nextInt();
		Sc = sc.nextInt();
		Fr = sc.nextInt();
		Fc = sc.nextInt();

		resul = Integer.MAX_VALUE;
		recur(Sr, Sc, 0);
		System.out.println(resul);
	}

	static boolean inMap(int x, int y) {
		return x >= 1 && x <= N && y >= 1 && y <= M;
	}

	// cnt인자는 이동 횟수
	static void recur(int x, int y, int cnt) {

		if (x == Fr && y == Fc) {
			resul = Math.min(cnt, resul);
			return;
		}

		// 사방향 탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			boolean chk = true;
			// 배열 안에 위치&&방문한적 없다면 이동~
			// 탐색 방향이 이동 가능 위치인지 확인(벽이 포함되는지 안 되는지)
			if (inMap(nx, ny) && visited[nx][ny] == false) {
				// 위로 올라간 경우
				if (i == 0) {
					for (int j = ny; j < ny+W; j++) {
						if (map[nx][j] == 1)
							chk = false;
					}
				} // 아래로
				else if (i == 1) {
					if (nx + H-1 > N)
						chk = false;
					else {
						for (int j = ny; j <ny+W; j++) {
							if (map[nx+H-1][j] == 1)
								chk = false;
						}
					}
				} // 왼쪽으로
				else if (i == 2) {
					for (int j = nx; j <nx+H; j++) {
						if (map[j][ny] == 1)
							chk = false;
					}
				} // 오른쪽으로
				else if (i == 3) {
					if (ny + W -1> M)
						chk = false;
					else {
						for (int j = nx; j <nx+H; j++) {
							if (map[j][ny+W-1] == 1)
								chk = false;
						}
					}
				}
				// 이동 가능이면 이동하기
				if (chk) {
					visited[nx][ny] = true;
					recur(nx, ny, cnt + 1);
					visited[nx][ny] = false;
				}
			}
		}
	}
}
