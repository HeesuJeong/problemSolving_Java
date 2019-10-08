import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ¾ç {

	static int R;
	static int C;
	static char[][] arr;
	static Queue<Point> q=new LinkedList<Point>();
	static Scanner sc=new Scanner(System.in);
	final static int[] dx= {-1,1,0,0};
	final static int[] dy= {0,0,-1,1};
	static int wolf;
	static int sheep;
	
	
	static boolean inArr(int x,int y) {
		return x>=0&&x<R&&y>=0&&y<C;
	}
	
	static void BFS(int x,int y) {
		if(arr[x][y]=='v') wolf++;
		else if(arr[x][y]=='o') sheep++;
		
		q.add(new Point(x,y));
		arr[x][y]='A';
		
		while(!q.isEmpty()) {
			Point now=q.poll();
			for(int i=0;i<4;i++) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				
				if(inArr(nx,ny)&&arr[nx][ny]!='#'&&arr[nx][ny]!='A') {
					if(arr[nx][ny]=='v') wolf++;
					else if(arr[nx][ny]=='o') sheep++;
					
					q.add(new Point(nx,ny));
					arr[nx][ny]='A';
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		R=sc.nextInt();
		C=sc.nextInt();
		arr=new char[R][C];
		for (int i = 0; i < R; i++) {
			String str=sc.next();
			for (int j = 0; j < C; j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		int totalsheep=0;
		int totalwolf=0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j]!='#'&&arr[i][j]!='A') {
					wolf=0;
					sheep=0;
					BFS(i,j);
					if(sheep>wolf) totalsheep+=sheep;
					else totalwolf+=wolf;
				}
			}
		}
		System.out.println(totalsheep+" "+totalwolf);
	}

}
