import java.util.Scanner;

public class 배열돌리기1 {

	static int N;
	static int M;
	static Scanner sc=new Scanner(System.in);
	static int R;
	static int[][] arr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=sc.nextInt();
		M=sc.nextInt();
		R=sc.nextInt();
		arr=new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
	}

}
