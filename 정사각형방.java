import java.util.Scanner;

public class 정사각형방 {

	static int TC;
	static Scanner sc=new Scanner(System.in);
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int[][] arr;
	static int N;
	static int resul=Integer.MIN_VALUE;
	static int resulNum;
	static boolean inArr(int x,int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			N=sc.nextInt();
			arr=new int[N][N];
			resul=Integer.MIN_VALUE;
			for (int i = 0; i <N; i++) {
				for (int j = 0; j <N; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			resulNum=Integer.MAX_VALUE;
			for (int i = 0; i <N; i++) {
				for (int j = 0; j <N; j++) {
					cnt=1;
					find(i,j);
					if(resul<cnt) {
						resulNum=arr[i][j];
						resul=cnt;
					}else if(resul==cnt&&resulNum>arr[i][j]) {
						resulNum=arr[i][j];
					}
				}
			}
			System.out.println("#"+tc+" "+resulNum+" "+resul);
		}//TC
	}
	static boolean nextPossible(int from,int to) {
		return to-from==1;
	}
	
	static int cnt;
	static void find(int x,int y) {
		for (int i = 0; i <4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(inArr(nx,ny)&&nextPossible(arr[x][y], arr[nx][ny])) {
				cnt++;
				find(nx,ny);
			}
		}
	}

}
