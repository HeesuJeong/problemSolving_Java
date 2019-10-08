import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class ¹Ì·ÎÅ½»ö {

	static int N;
	static int M;
	static Scanner sc = new Scanner(System.in);
	static int[][] arr;
	static boolean[][] visited;
	static Queue<Point> q;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ans = 1;

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		q = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				int input = str.charAt(j) - '0';
				arr[i][j] = input;
				visited[i][j] = false;
			}
		}

		BFS(0, 0);
		
	}

	static boolean inArr(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static void BFS(int x, int y) {
		q.add(new Point(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int sz = q.size();
			for (int z = 0; z < sz; z++) {
				Point np = q.poll();
				if (np.x == N - 1 && np.y == M - 1) {
					System.out.println(ans);
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nx = np.x + dx[i];
					int ny = np.y + dy[i];
					if (inArr(nx, ny) && arr[nx][ny] == 1 && visited[nx][ny] == false) {
						visited[nx][ny] = true;
						q.add(new Point(nx, ny));

					}
				}
			}
			ans++;
		}
	}
}
