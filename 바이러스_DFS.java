import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스_DFS {

	static int[][] arr;
	static int N;
	static int connecNum;
	static Scanner sc=new Scanner(System.in);
	static boolean[] visited;
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
		 
		
		System.out.println(cnt);
	}

	static void DFS() {
		
	}
}
