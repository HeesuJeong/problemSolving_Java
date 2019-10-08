import java.util.Scanner;

public class ¼³ÅÁ¹è´Ş {

	static int input;
	static Scanner sc = new Scanner(System.in);
	static int[] arr = { 3, 5 };
	static int resul = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = sc.nextInt();
		combi(0, 0, 0);
		System.out.println(resul);
	}

	static void combi(int n, int sum, int cnt) {
		if (sum == input) {
			resul = Math.min(resul, cnt);
			return;
		}
		if (sum > input) {
			resul=-1;
			return;
		}

		for (int i = n; i < arr.length; i++) {
			int tmp = arr[i];
			combi(i, sum + tmp, cnt + 1);
		}
	}

}
