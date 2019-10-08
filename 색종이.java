import java.util.Scanner;

public class »öÁ¾ÀÌ {

	static int N;
	static Scanner sc=new Scanner(System.in);
	static boolean[][] arr=new boolean[101][101];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=sc.nextInt();
		int cnt=0;
		for (int i = 0; i <N; i++) {
			int y=sc.nextInt();
			int x=sc.nextInt();
			for (int j = x; j <x+10; j++) {
				for (int j2 = y; j2 <y+10; j2++) {
					if(arr[j][j2]==false) {
						arr[j][j2]=true;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
