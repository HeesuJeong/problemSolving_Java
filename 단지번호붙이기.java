import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

//DFS로 풀었다.
public class 단지번호붙이기 {

	static int N;
	static int[][] arr;
	static Scanner sc = new Scanner(System.in);
	static int cnt=0;
	
	final static int[] dx= {-1,1,0,0};
	final static int[] dy= {0,0,-1,1};
	
	public static boolean inArr(int nx,int ny) {
		return nx>=0&&nx<N&&ny>=0&&ny<N;
	}
	
	public static void DFS(int x, int y) {
		arr[x][y]=-1;
		cnt++;
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(inArr(nx,ny)&&arr[nx][ny]==1) {
				DFS(nx,ny);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = sc.nextInt();
		arr=new int[N][N];
		Vector<Integer> v=new Vector<>();
		
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					cnt=0;
					DFS(i, j);
					v.add(cnt);
				}
			}
		}
		System.out.println(v.size());
		Collections.sort(v);
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
	}// main

}
