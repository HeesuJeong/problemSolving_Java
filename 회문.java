import java.util.Scanner;

public class ȸ�� {

	static int N;
	static Scanner sc = new Scanner(System.in);
	static char[][] map;
	static int TC;
	static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int tc = 1; tc <= 10; tc++) {
			count = 0;
			N = sc.nextInt();
			map = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String str = sc.next();
				for (int j = 0; j < 8; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					/// ���� ����
					int left = j;
					int right = j + N - 1;
					if (right < 8) {
						boolean chk = false;
						// right�� left���� �۾����� => stop
						while (left <= right) {
							if (map[i][left] != map[i][right]) {
								// �ٸ��� ����
								chk = true;
								break;
							}
							left++;
							right--;
						}
						if (chk == false) {
							count++;
						}
					}
					///// ���� ����
					int up = i;
					int down = i + N - 1;
					if (down < 8) {
						boolean chk = false;
						while (up <= down) {
							if (map[up][j] != map[down][j]) {
								// �ٸ��� ����
								chk = true;
								break;
							}
							up++;
							down--;
						}
						if (chk == false) {
							count++;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}// tc
}
