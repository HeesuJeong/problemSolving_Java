import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//실패한 코드******************************

public class 구슬탈출 {

	static int N;
	static int M;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Scanner sc = new Scanner(System.in);
	static int resul; // 우리는 최소 구하기이다!!!

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
	static int CNT; // 10회 넘으면 실패!

	// 동시에 빠져도 안 돼
	// 한 공간에 둘이 안 돼(즉 .과 O 길 최대로 들어가)=>O 둘 다 도달하면 실패
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		q = new LinkedList<Point>();
		// 최소값 구해야 하기 때문에 최대값으로 초기화
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

		// 시작위치 큐에 저장
		q.add(p);
		// 빨강이 승자이면 [0]==-1 파랑이 승자이면 -2 무승부 -3 결정 안 나면 0이상
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
			//System.out.println("시작  좌표 " + p.rx + " " + p.ry + " " + p.bx + " " + p.by);
			for (int i = 0; i < 4; i++) {
				inputArr = move(i, p.rx, p.ry, p.bx, p.by);
				//System.out.println("돌고 나서 좌표 " + inputArr[0] + " " + inputArr[1] + " " + inputArr[2] + " " + inputArr[3]);
				if (p.cnt+1 > 10) 
					return -3; // 10회 이상 게임은 무승부와 같다
				if (inputArr[0] == -1) //빨강 win
					return p.cnt + 1; 
				if(inputArr[0] == -3)
					return -3; //무승부
				// 파랑이 승자이거나 or move 전후가 같으면 Nope
				if (inputArr[0] == -2
						|| (p.rx == inputArr[0] && p.ry == inputArr[1] && p.bx == inputArr[2] && p.by == inputArr[3]))
					continue;
				q.add(new Point(inputArr[0], inputArr[1], inputArr[2], inputArr[3], p.cnt + 1));

			}
		}
		return -3;// 큐 다 비워진건 무승부
	}

//빨강이 승자이면  [0]==-1 파랑이 승자이면 -2 무승부 -3 결정 안 나면  0이상
	static int[] move(int dir, int irx, int iry, int ibx, int iby) {
		// 움직였다면 변경한 위치 리턴
		// 안 움직였으면 기존 자리 리턴해야해
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
		// 우선 현위치 저장
		returnArr[0] = irx;
		returnArr[1] = iry;
		returnArr[2] = ibx;
		returnArr[3] = iby;
		// 범위밖이면 그냥 끝내
		if (!inMap(rx, ry) || !inMap(bx, by)) {
			returnArr[0] = -3;
			return returnArr;
		}
		//System.out.println("보는 위치: " + rx + " " + ry + " " + bx + " " + by);

		// 빨강 위한 정보
		int cnt = 0;
		boolean chk = false;
		boolean moveChk = false;
		// 파랑 위한 정보
		int cnt2 = 0;
		boolean chk2 = false;
		boolean moveChk2 = false;

		// 위로 기울이기
		if (dir == 0) {
			// 빨강 올리기
			while (rx >= 0 && (map[rx][ry] == '.' || map[rx][ry] == 'O')) {
				moveChk = true;
				if (map[rx][ry] == 'O') {
					chk = true;
					break; // 계속 올라가다가 구멍에 빠지면 그만 올라가
				}
				cnt++; // 몇 차례 이동 하였는지 확인 필요해
				rx--; // 위로 올라가기
			}
			rx++;
			// 파랑 올리기
			while (bx >= 0 && (map[bx][by] == '.' || map[bx][by] == 'O')) {
				moveChk2 = true;
				if (map[bx][by] == 'O') {
					chk2 = true;
					break;
				}
				cnt2++; // 몇 차례 이동 하였는지 확인 필요해
				bx--; // 위로 올라가기
			}
			bx++;
		}
		// 아래로 기울이기
		else if (dir == 1) {
			while (rx < N && (map[rx][ry] == '.' || map[rx][ry] == 'O')) {
				moveChk = true;
				if (map[rx][ry] == 'O') {
					chk = true;
					break;
				}
				cnt++;
				rx++; // 아래로 내려가기
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
		// 좌로 기울이기
		else if (dir == 2) {
			while (ry >= 0 && (map[rx][ry] == '.' || map[rx][ry] == 'O')) {
				moveChk = true;
				if (map[rx][ry] == 'O') {
					chk = true;
					break;
				}
				cnt++;
				ry--; // 왼족으로
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
		// 우로 기울이기
		else if (dir == 3) {
			while (ry < M && (map[rx][ry] == '.' || map[rx][ry] == 'O')) {
				moveChk = true;
				if (map[rx][ry] == 'O') {
					chk = true;
					break;
				}
				cnt++;
				ry++; // 오른족으로
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

		// 하나라도 골인되었다면
		if (chk == true || chk2 == true) {
			if (chk == true && chk2 == false) {
				// 빨강만 골인
				returnArr[0] = -1;
			} else if (chk == false && chk2 == true) {
				returnArr[0] = -2;
			} else if (chk == true && chk2 == true) {
				returnArr[0] = -3;
			}
			return returnArr;
		}
		// 같은 위치에 저장된 경우 cnt로 비교
		// 더 많이 이동한 사람을 한칸 뒤로
		if (bx == rx && by == ry) {
			// System.out.println("충돌!!! " + rx + " " + ry + " " + bx + " " + by);
			// 같이 구멍에 빠졌다면
			if (dir == 0) {
				if (cnt > cnt2) // 빨강이 더 많이 움직인 경우
					returnArr[0]++;
				else // 파랑이 더 많이 움직인 경우
					returnArr[2]++;
			} else if (dir == 1) {
				if (cnt > cnt2) // 빨강이 더 많이 움직인 경우
					returnArr[0]--;
				else // 파랑이 더 많이 움직인 경우
					returnArr[2]--;
			} else if (dir == 2) {
				if (cnt > cnt2) // 빨강이 더 많이 움직인 경우
					returnArr[1]++;
				else // 파랑이 더 많이 움직인 경우
					returnArr[3]++;
			} else if (dir == 3) {
				if (cnt > cnt2) // 빨강이 더 많이 움직인 경우
					returnArr[1]--;
				else // 파랑이 더 많이 움직인 경우
					returnArr[3]--;
			}
		}
		return returnArr;
	}

}
