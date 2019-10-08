import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;

public class ¿¬±¸¼Ò {

	static int N;
	static int M;
	static Scanner sc=new Scanner(System.in);
	static int[][] arr;
	static int[][] temp;
	final static int[] dx= {-1,1,0,0};
	final static int[] dy= {0,0,-1,1};
	
	static boolean chk(Point p) {
		return p.x>=0&&p.x<N&&p.y>=0&&p.y<M;
	}
	
	static void virusDFS() {
		
	}
	
	static void show() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("=============");
	}
	
	//0 ºóÄ­ 1 º® 2 ¹ÙÀÌ·¯½º
	static void wallDFS(Point p,int cnt) {
		if(cnt==3) {
			//virusDFS();
			show();
			return;
		}
		temp[p.x][p.y]=9;
		
		for (int i = 0; i < 4; i++) {
			int nx=p.x+dx[i];
			int ny=p.y+dy[i];
				if(chk(new Point(nx,ny))&&temp[nx][ny]==0) {
					wallDFS(new Point(nx,ny),cnt+1);
					temp[nx][ny]=0;
				}
		}
		
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N][M];
		temp=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==0) {
					temp=arr.clone();
					wallDFS(new Point(i,j),1);
				}
			}
		}
	}

}
