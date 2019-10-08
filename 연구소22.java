import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소22 {

	static int N;
	static int M;
	static Scanner sc = new Scanner(System.in);
	static int[][] arr;
	static int[][] tmp;
	static Queue<Point> q;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int count;
	static boolean realchk;
	static int resul = Integer.MAX_VALUE;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][N];
		tmp = new int[N][N];
		q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int input = sc.nextInt();
				arr[i][j] = input;
			}
		}

		/////////
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 2) {
					// 바이러스 둘 수 있는 자리에 실제로 바이러스를 둔다
					// 실제 바이러스는 -1로 표시
					arr[i][j] = -1;
					recur(1, i);
					arr[i][j] = 2; // 다시 원상 복귀
				}
			}
		}

		// 모두 0이 아닐 때, 즉 바이러스 없이 빈 공간 없을 때!
		if (realchk == true)
			System.out.println(resul);
		else
			System.out.println("-1");
	}

	static void recur(int c, int x) {
		if (c == M) {
			count = 1;
			copyArr();
			spread();// 바이러스들 큐에 담기
			BFS();
			boolean chk = chk();
			if (chk == true)
				realchk = true; // 바이러스 모두 퍼트리는 경우 존재한다
			return;
		}
		for (int i = x; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 2) {
					arr[i][j] = -1;
					recur(c + 1, i);
					arr[i][j] = 2;
				}
			}
		}
	}

	static void printArr() {
		System.out.println("================");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean inArr(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static void spread() {
		// 바이러스 위치들 큐에 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (tmp[i][j] == -1) {
					q.add(new Point(i, j));
				}
			}
		}
	}

	static void BFS() {
		while (!q.isEmpty()) {
			int sz = q.size();
			for (int i = 0; i < sz; i++) {
				Point np = q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = np.x + dx[j];
					int ny = np.y + dy[j];
					if (inArr(nx, ny) && tmp[nx][ny] == 0) {
						tmp[nx][ny] = count;
						q.add(new Point(nx, ny));
					}
				}
			}
			// System.out.println(count+" ");
			count++;
			/*
			 * System.out.println("count 업데이트 "+count+",큐 사이즈 "+q.size()); printArr();
			 */
		}
	}

	static void copyArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 벽:1 바이러스:-1 빈공간:0
				int a = arr[i][j];
				if (a == 2)
					a = 0;
				tmp[i][j] = a;
			}
		}
	}

	// 바이러스 안 퍼진 곳이 있나 검사
	static boolean chk() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (tmp[i][j] == 0)
					continue;
				else
					cnt++;
			}
		}

		// 바이러스가 모두 퍼졌다면 true
		if (cnt == N * N) {
			resul=Math.min(resul, count-2);
			return true;
		} else
			return false;

	}

}
