import java.util.Scanner;

public class ����Ʈ���� {

	static int T;
	static int N;
	static String[] strArr;
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N=sc.nextInt();
			strArr=new String[N];
			for (int i = 0; i < N; i++) {
				strArr[i]=sc.next();
			}
			//¦���̸�
			System.out.print("#"+tc+" ");
			if(N%2==0) {
				int jmp=N/2;
				for (int i = 0; i < N/2; i++) {
					System.out.print(strArr[i]+" ");
					System.out.print(strArr[i+jmp]+" ");
				}
			}
			//Ȧ���̸�
			else {
				int jmp=N/2;
				for (int i = 0; i < N/2; i++) {
					System.out.print(strArr[i]+" ");
					System.out.print(strArr[i+jmp+1]+" ");
				}
				System.out.print(strArr[jmp]+" ");
			}
			System.out.println();
		}//tc
	}

}
