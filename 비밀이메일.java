import java.util.Scanner;

public class 비밀이메일 {

	static String input = new String();
	static Scanner sc = new Scanner(System.in);
	static int R;
	static int C;
	static char[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = sc.next();
		int size = input.length();

		for (int i = 1; i <= (int) (Math.sqrt(size)); i++) {
			if (size % i == 0)
				C = i;
		}
		R = size / C;
//		System.out.println(R+" "+C);
		arr = new char[R][C];
		System.out.println(R + " " + C);

		int idx = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				arr[i][j] = input.charAt(idx++);
			}
		}
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				System.out.print(arr[i][j]);
			}
		}
		System.out.println();
	}

}
