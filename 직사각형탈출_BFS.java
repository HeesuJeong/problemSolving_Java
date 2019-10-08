import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 직사각형탈출_BFS {

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

	static Queue<Point> q;

	static class Point {
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			//전역으로 카운트하면 자식들끼리 같이 ++되기 때문에
			//변수로 들고다녀야한다
			this.cnt=cnt;
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
		q = new LinkedList<>();
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
		// 시작 위치 담기
		q.add(new Point(Sr, Sc,0));
		visited[Sr][Sc] = true;
		
		resul = Integer.MAX_VALUE;
		BFS();
		
		System.out.println(resul==Integer.MAX_VALUE?-1:resul);
	}

	static boolean inMap(int x, int y) {
		return x >= 1 && x <= N && y >= 1 && y <= M;
	}

	static int count=0;
	static void BFS() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == Fr && p.y == Fc) {
				resul = Math.min(p.cnt, resul);
				break;
			}
			for (int i = 0; i <4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (inMap(nx, ny) && visited[nx][ny] == false) {
					if(moveMove(i, nx, ny)) {
						//이동가능
						visited[nx][ny] = true;
						count++;
						q.add(new Point(nx,ny,p.cnt+1));
					}
				}
			}
		}
	}// bfs

	static boolean moveMove(int i, int nx, int ny) {
		// 위로 올라간 경우
		if (i == 0) {
			for (int j = ny; j < ny + W; j++) {
				if (map[nx][j] == 1)
					return false;
			}
		} // 아래로
		else if (i == 1) {
			if (nx + H - 1 > N)
				return false;
			else {
				for (int j = ny; j < ny + W; j++) {
					if (map[nx + H - 1][j] == 1)
						return false;
				}
			}
		} // 왼쪽으로
		else if (i == 2) {
			for (int j = nx; j < nx + H; j++) {
				if (map[j][ny] == 1)
					return false;
			}
		} // 오른쪽으로
		else if (i == 3) {
			if (ny + W - 1 > M)
				return false;
			else {
				for (int j = nx; j < nx + H; j++) {
					if (map[j][ny + W - 1] == 1)
						return false;
				}
			}
		}
		return true;
	}// move
}
