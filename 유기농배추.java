import java.util.Scanner;

public class ¿Ø±‚≥ÛπË√ﬂ {

	static int TC;
	static int M;
	static int N;
	static int K;
	static int x;
	static int y;
	static int resul;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static Scanner sc=new Scanner(System.in);
	static int[][] arr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			resul=0;
			M=sc.nextInt();
			N=sc.nextInt();
			arr=new int[N][M];
			K=sc.nextInt();
			for (int i = 0; i < K; i++) {
				y=sc.nextInt();
				x=sc.nextInt();
				arr[x][y]=1;
			}
			for (int i = 0; i <N; i++) {
				for (int j = 0; j <M; j++) {
					if(arr[i][j]==1) {
						DFS(i,j);
						resul++;
					}
				}
			}
			System.out.println(resul);
		}//tc
	}
	static boolean inArr(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<M;
	}
	static void DFS(int x,int y) {
		for (int i = 0; i < 4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(inArr(nx,ny)&&arr[nx][ny]==1) {
				arr[nx][ny]=-1;
				DFS(nx,ny);
			}
		}
	}

}