import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//������ �ڵ�******************************

public class ����Ż�� {

	static int N;
	static int M;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Scanner sc = new Scanner(System.in);
	static int resul; // �츮�� �ּ� ���ϱ��̴�!!!

	static boolean inMap(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static class Point {
		int rx;
		int ry;
		int bx;
		int by;
		int cnt;

		public Point(int rx, int ry, int bx, int by, int cnt) {
			// TODO Auto-generated constructor stub
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}

		public Point() {
			// TODO Auto-generated constructor stub
		}
	}

	static Queue<Point> q;
	static int CNT; // 10ȸ ������ ����!

	// ���ÿ� ������ �� ��
	// �� ������ ���� �� ��(�� .�� O �� �ִ�� ��)=>O �� �� �����ϸ� ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		q = new LinkedList<Point>();
		// �ּҰ� ���ؾ� �ϱ� ������ �ִ밪���� �ʱ�ȭ
		resul = Integer.MAX_VALUE;
		Point p = new Point();
		p.cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				char input = str.charAt(j);
				if (input == 'R') {
					p.rx = i;
					p.ry = j;
				} else if (input == 'B') {
					p.bx = i;
					p.by = j;
				}
				if (input == 'B' || input == 'R')
					input = '.';
				map[i][j] = input;
			}
		}

		// ������ġ ť�� ����
		q.add(p);
		// ������ �����̸� [0]==-1 �Ķ��� �����̸� -2 ���º� -3 ���� �� ���� 0�̻�
		int resul = BFS();
		if (resul > 0)
			System.out.println(resul);
		else if (resul == -2 || resul == -3)
			System.out.println(-1);
	}// main

	static int BFS() {
		int[] inputArr = new int[4];
		while (!q.isEmpty()) {
			Point p = q.poll();
			//System.out.println("����  ��ǥ " + p.rx + " " + p.ry + " " + p.bx + " " + p.by);
			for (int i = 0; i < 4; i++) {
				inputArr = move(i, p.rx, p.ry, p.bx, p.by);
				//System.out.println("���� ���� ��ǥ " + inputArr[0] + " " + inputArr[1] + " " + inputArr[2] + " " + inputArr[3]);
				if (p.cnt+1 > 10) 
					return -3; // 10ȸ �̻� ������ ���ºο� ����
				if (inputArr[0] == -1) //���� win
					return p.cnt + 1; 
				if(inputArr[0] == -3)
					return -3; //���º�
				// �Ķ��� �����̰ų� or move ���İ� ������ Nope
				if (inputArr[0] == -2
						|| (p.rx == inputArr[0] && p.ry == inputArr[1] && p.bx == inputArr[2] && p.by == inputArr[3]))
					continue;
				q.add(new Point(inputArr[0], inputArr[1], inputArr[2], inputArr[3], p.cnt + 1));

			}
		}
		return -3;// ť �� ������� ���º�
	}

//������ �����̸�  [0]==-1 �Ķ��� �����̸� -2 ���º� -3 ���� �� ����  0�̻�
	static int[] move(int dir, int irx, int iry, int ibx, int iby) {
		// �������ٸ� ������ ��ġ ����
		// �� ���������� ���� �ڸ� �����ؾ���
		int rx = irx;
		int ry = iry;
		int bx = ibx;
		int by = iby;

		if (dir == 0) {
			rx -= 1;
			bx -= 1;
		} else if (dir == 1) {
			rx += 1;
			bx += 1;
		} else if (dir == 2) {
			ry -= 1;
			by -= 1;
		} else if (dir == 3) {
			ry += 1;
			by += 1;
		}
		int[] returnArr = { 0, 0, 0, 0 };
		// �켱 ����ġ ����
		returnArr[0] = irx;
		returnArr[1] = iry;
		returnArr[2] = ibx;
		returnArr[3] = iby;
		// �������̸� �׳� ����
		if (!inMap(rx, ry) || !inMap(bx, by)) {
			returnArr[0] = -3;
			return returnArr;
		}
		//System.out.println("���� ��ġ: " + rx + " " + ry + " " + bx + " " + by);

		// ���� ���� ����
		int cnt = 0;
		boolean chk = false;
		boolean moveChk = false;
		// �Ķ� ���� ����
		int cnt2 = 0;
		boolean chk2 = false;
		boolean moveChk2 = false;

		// ���� ����̱�
		if (dir == 0) {
			// ���� �ø���
			while (rx >= 0 && (map[rx][ry] == '.' || map[rx][ry] == 'O')) {
				moveChk = true;
				if (map[rx][ry] == 'O') {
					chk = true;
					break; // ��� �ö󰡴ٰ� ���ۿ� ������ �׸� �ö�
				}
				cnt++; // �� ���� �̵� �Ͽ����� Ȯ�� �ʿ���
				rx--; // ���� �ö󰡱�
			}
			rx++;
			// �Ķ� �ø���
			while (bx >= 0 && (map[bx][by] == '.' || map[bx][by] == 'O')) {
				moveChk2 = true;
				if (map[bx][by] == 'O') {
					chk2 = true;
					break;
				}
				cnt2++; // �� ���� �̵� �Ͽ����� Ȯ�� �ʿ���
				bx--; // ���� �ö󰡱�
			}
			bx++;
		}
		// �Ʒ��� ����̱�
		else if (dir == 1) {
			while (rx < N && (map[rx][ry] == '.' || map[rx][ry] == 'O')) {
				moveChk = true;
				if (map[rx][ry] == 'O') {
					chk = true;
					break;
				}
				cnt++;
				rx++; // �Ʒ��� ��������
			}
			rx--;
			while (bx < N && (map[bx][by] == '.' || map[bx][by] == 'O')) {
				moveChk2 = true;
				if (map[bx][by] == 'O') {
					chk2 = true;
					break;
				}
				cnt2++;
				bx++;
			}
			bx--;
		}
		// �·� ����̱�
		else if (dir == 2) {
			while (ry >= 0 && (map[rx][ry] == '.' || map[rx][ry] == 'O')) {
				moveChk = true;
				if (map[rx][ry] == 'O') {
					chk = true;
					break;
				}
				cnt++;
				ry--; // ��������
			}
			ry++;
			while (by >= 0 && (map[bx][by] == '.' || map[bx][by] == 'O')) {
				moveChk2 = true;
				if (map[bx][by] == 'O') {
					chk2 = true;
					break;
				}
				cnt2++;
				by--;
			}
			by++;
		}
		// ��� ����̱�
		else if (dir == 3) {
			while (ry < M && (map[rx][ry] == '.' || map[rx][ry] == 'O')) {
				moveChk = true;
				if (map[rx][ry] == 'O') {
					chk = true;
					break;
				}
				cnt++;
				ry++; // ����������
			}
			ry--;
			while (by < M && (map[bx][by] == '.' || map[bx][by] == 'O')) {
				moveChk2 = true;
				if (map[bx][by] == 'O') {
					chk2 = true;
					break;
				}
				cnt2++;
				by++;
			}
			by--;
		}

		if (moveChk) {
			returnArr[0] = rx;
			returnArr[1] = ry;
		}
		if (moveChk2) {
			returnArr[2] = bx;
			returnArr[3] = by;
		}

		// �ϳ��� ���εǾ��ٸ�
		if (chk == true || chk2 == true) {
			if (chk == true && chk2 == false) {
				// ������ ����
				returnArr[0] = -1;
			} else if (chk == false && chk2 == true) {
				returnArr[0] = -2;
			} else if (chk == true && chk2 == true) {
				returnArr[0] = -3;
			}
			return returnArr;
		}
		// ���� ��ġ�� ����� ��� cnt�� ��
		// �� ���� �̵��� ����� ��ĭ �ڷ�
		if (bx == rx && by == ry) {
			// System.out.println("�浹!!! " + rx + " " + ry + " " + bx + " " + by);
			// ���� ���ۿ� �����ٸ�
			if (dir == 0) {
				if (cnt > cnt2) // ������ �� ���� ������ ���
					returnArr[0]++;
				else // �Ķ��� �� ���� ������ ���
					returnArr[2]++;
			} else if (dir == 1) {
				if (cnt > cnt2) // ������ �� ���� ������ ���
					returnArr[0]--;
				else // �Ķ��� �� ���� ������ ���
					returnArr[2]--;
			} else if (dir == 2) {
				if (cnt > cnt2) // ������ �� ���� ������ ���
					returnArr[1]++;
				else // �Ķ��� �� ���� ������ ���
					returnArr[3]++;
			} else if (dir == 3) {
				if (cnt > cnt2) // ������ �� ���� ������ ���
					returnArr[1]--;
				else // �Ķ��� �� ���� ������ ���
					returnArr[3]--;
			}
		}
		return returnArr;
	}

}
