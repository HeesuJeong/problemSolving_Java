import java.util.Scanner;

public class 색종이붙이기 {

	static int[][] arr;
	static Scanner sc = new Scanner(System.in);
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int[] caseArr = { 0, 5, 5, 5, 5, 5 };
	static int resul;
	static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arr = new int[10][10];
		resul = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dfs(0);
		System.out.println(resul == Integer.MAX_VALUE ? -1 : resul);
	}
 
	// 기저는 색종이 안 남거나~ 1이 안 남거나~
	// cnt는 지금까지 붙인 색종이 갯수 => 25개면 부족!
	static void dfs(int cnt) {
		//최소값 구하기이므로 넘으면 return
		if(cnt>resul) return;
		// cnt가 25이면 색종이 부족한 것
		// 왼쪽과 위가 1인 위치를 찾는다 => 없으면 완료=> cnt를 정답에 저장(최소값 유지 필요)
		// 있다면 가능한 모든 크기의 색종이 붙이고 다음 재귀 호출
		int startX = Integer.MIN_VALUE;
		int startY = Integer.MIN_VALUE;
		loop: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (arr[i][j] == 1) {
					startX = i;
					startY = j;
					break loop;
				}
			}
		}
		// 없으면 덮을 곳이 남지 않았다! 완료...현재 cnt 정답에 저장
		if (startX == Integer.MIN_VALUE && startY == Integer.MIN_VALUE) {
			resul = Math.min(resul, cnt);
			return;
		}
		// startX와 startY에서 붙일 수 있는 가장 큰 색종이는?
		int max = 5;
		while (max > 0) {
			boolean chk = true;
			loop: for (int i = startX; i < startX + max; i++) {
				for (int j = startY; j < startY + max; j++) {
					// 범위 나가거나 0을 만나면
					if (!inArr(i, j) || arr[i][j] == 0) {
						chk = false;
						break;
					}
				}
			}
			if (chk)
				break;
			max--;
		}
		// 있다면 가능한 모든 크기의 색종이 붙인다.
		for (int i = max; i > 0; i--) {
			// max크기만큼 0으로 바꾸고 , 사용한 색종이 한장 줄이기
			if (caseArr[i] > 0) {
				for (int j = startX; j < startX + i; j++) {
					for (int k = startY; k < startY + i; k++) {
						arr[j][k] = 0;
					}
				}
				caseArr[i]--;
				// 재귀 호출
				dfs(cnt + 1);
				// 다시 1로 바꾸기, 사용한 색종이 다시 늘리기
				for (int j = startX; j < startX + i; j++) {
					for (int k = startY; k < startY + i; k++) {
						arr[j][k] = 1;
					}
				}
				caseArr[i]++;
			}
		}
	}

	static boolean inArr(int x, int y) {
		return x >= 0 && x < 10 && y >= 0 && y < 10;
	}
}
