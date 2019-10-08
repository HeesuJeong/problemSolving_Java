import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스_BFS {

	static int[][] arr;
	static int N;
	static int connecNum;
	static Scanner sc=new Scanner(System.in);
	static boolean[] visited;
	static Queue<Point> q=new LinkedList<Point>();
	static int cnt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=sc.nextInt();
		arr=new int[N+2][N+2];
		visited=new boolean[N+2];
		connecNum=sc.nextInt();
		for (int i = 0; i < connecNum; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			arr[x][y]=1;
			arr[y][x]=1;
		}
		
		visited[1]=true;
		for (int i = 1; i <=N; i++) {
			if(arr[1][i]==1) {
				cnt++;
				///System.out.println(i+"~");
				System.out.println(1+" "+i);
				System.out.println(Arrays.toString(visited));
				q.add(new Point(1,i));
				visited[i]=true;
			}
		}
		DFS();
		System.out.println(cnt);
	}

	static void DFS() {
		while(!q.isEmpty()) {
			Point n=q.poll();
			int nx=n.x;
			int ny=n.y;
			for (int i = 1; i <=N; i++) {
				if(arr[ny][i]==1&&visited[i]==false) {
					cnt++;
					///System.out.println(i+"~");
					System.out.println(ny+" "+i);
					System.out.println(Arrays.toString(visited));
					q.add(new Point(ny,i));
					visited[i]=true;
				}
			}
		}
	}
}
