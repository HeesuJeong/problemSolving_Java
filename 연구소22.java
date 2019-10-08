import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ������22 {

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
					// ���̷��� �� �� �ִ� �ڸ��� ������ ���̷����� �д�
					// ���� ���̷����� -1�� ǥ��
					arr[i][j] = -1;
					recur(1, i);
					arr[i][j] = 2; // �ٽ� ���� ����
				}
			}
		}

		// ��� 0�� �ƴ� ��, �� ���̷��� ���� �� ���� ���� ��!
		if (realchk == true)
			System.out.println(resul);
		else
			System.out.println("-1");
	}

	static void recur(int c, int x) {
		if (c == M) {
			count = 1;
			copyArr();
			spread();// ���̷����� ť�� ���
			BFS();
			boolean chk = chk();
			if (chk == true)
				realchk = true; // ���̷��� ��� ��Ʈ���� ��� �����Ѵ�
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
		// ���̷��� ��ġ�� ť�� ����
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
			 * System.out.println("count ������Ʈ "+count+",ť ������ "+q.size()); printArr();
			 */
		}
	}

	static void copyArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// ��:1 ���̷���:-1 �����:0
				int a = arr[i][j];
				if (a == 2)
					a = 0;
				tmp[i][j] = a;
			}
		}
	}

	// ���̷��� �� ���� ���� �ֳ� �˻�
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

		// ���̷����� ��� �����ٸ� true
		if (cnt == N * N) {
			resul=Math.min(resul, count-2);
			return true;
		} else
			return false;

	}

}
