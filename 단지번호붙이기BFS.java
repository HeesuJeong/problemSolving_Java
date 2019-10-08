import java.awt.Point;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class 단지번호붙이기BFS {

	static int[][] arr;
	static int N;
	static int cnt=0;
	static Scanner sc=new Scanner(System.in);
	static Queue<Point> q=new LinkedList<>();
	static Vector<Integer> v=new Vector<>();
	
	final static int[] dx= {-1,1,0,0};
	final static int[] dy= {0,0,-1,1};
	
	public static boolean inArr(int nx,int ny) {
		return nx>=0&&nx<N&&ny>=0&&ny<N;
	}
	
	static void BFS(int x,int y) {
		q.add(new Point(x,y));
		arr[x][y]=-1;
		cnt++;
		
		while(!q.isEmpty()) {
			Point now=q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				
				if(inArr(nx,ny)&&arr[nx][ny]==1) {
					q.add(new Point(nx,ny));
					arr[nx][ny]=-1;
					cnt++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=sc.nextInt();
		arr=new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str=sc.next();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j]=str.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==1) {
					cnt=0;
					BFS(i,j);
					v.add(cnt);
				}
			}
		}
		System.out.println(v.size());
		Collections.sort(v);
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
	}

}
