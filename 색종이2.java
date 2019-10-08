import java.util.Scanner;

public class ������2 {
	static int N;
	static Scanner sc=new Scanner(System.in);
	static boolean[][] arr=new boolean[102][102];
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int resul;
	
	public static void main(String[] args) {
		N=sc.nextInt();
		int cnt=0;
		for (int i = 0; i <N; i++) {
			int y=sc.nextInt();
			int x=sc.nextInt();
			for (int j = x; j <x+10; j++) {
				for (int j2 = y; j2 <y+10; j2++) {
					if(arr[j][j2]==false) {
						arr[j][j2]=true;
					}
				}
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(arr[i][j]==true) {
					resul+=check(i,j);
				}
			}
		}
		System.out.println(resul);
	}
	static int check(int x,int y) {
		int cnt=0;
		//�׵θ��� ��쿡 true
		for (int i = 0; i < 4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(arr[nx][ny]==false) {
				//�ϳ��� false�� �����ٴ� ���� �׵θ���� ��!
				cnt++;
			}
		}
		return cnt;
	}
}
