import java.util.Scanner;

public class �����̺��̱� {

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
 
	// ������ ������ �� ���ų�~ 1�� �� ���ų�~
	// cnt�� ���ݱ��� ���� ������ ���� => 25���� ����!
	static void dfs(int cnt) {
		//�ּҰ� ���ϱ��̹Ƿ� ������ return
		if(cnt>resul) return;
		// cnt�� 25�̸� ������ ������ ��
		// ���ʰ� ���� 1�� ��ġ�� ã�´� => ������ �Ϸ�=> cnt�� ���信 ����(�ּҰ� ���� �ʿ�)
		// �ִٸ� ������ ��� ũ���� ������ ���̰� ���� ��� ȣ��
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
		// ������ ���� ���� ���� �ʾҴ�! �Ϸ�...���� cnt ���信 ����
		if (startX == Integer.MIN_VALUE && startY == Integer.MIN_VALUE) {
			resul = Math.min(resul, cnt);
			return;
		}
		// startX�� startY���� ���� �� �ִ� ���� ū �����̴�?
		int max = 5;
		while (max > 0) {
			boolean chk = true;
			loop: for (int i = startX; i < startX + max; i++) {
				for (int j = startY; j < startY + max; j++) {
					// ���� �����ų� 0�� ������
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
		// �ִٸ� ������ ��� ũ���� ������ ���δ�.
		for (int i = max; i > 0; i--) {
			// maxũ�⸸ŭ 0���� �ٲٰ� , ����� ������ ���� ���̱�
			if (caseArr[i] > 0) {
				for (int j = startX; j < startX + i; j++) {
					for (int k = startY; k < startY + i; k++) {
						arr[j][k] = 0;
					}
				}
				caseArr[i]--;
				// ��� ȣ��
				dfs(cnt + 1);
				// �ٽ� 1�� �ٲٱ�, ����� ������ �ٽ� �ø���
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
