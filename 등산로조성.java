import java.util.LinkedList;
import java.util.Scanner;

public class 등산로조성 {

	static int TC;
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static Scanner sc=new Scanner(System.in);
	static int resul; //결과값
	static int max; //가장 높은 높이
	static int cnt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			N=sc.nextInt();
			//배열 초기화
			map=new int[N][N];
			visited=new boolean[N][N];
			//매번 초기화
			max=Integer.MIN_VALUE;
			resul=Integer.MIN_VALUE;
			
			K=sc.nextInt();
			for (int i = 0; i <N; i++) {
				for (int j = 0; j <N; j++) {
					int input=sc.nextInt();
					map[i][j]=input;
					max=Math.max(max, input);
				}
			}
			for (int i = 0; i <N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==max) {
						visited[i][j]=true;
						DFS(i,j,1,false);
						visited[i][j]=false;
					}
				}
			}
			
			System.out.println("#"+tc+" "+resul);
		}//tc
	}

	static boolean inMap(int x,int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	
	static boolean compare(int from,int to) {
		return from>to;
	}
	static void DFS(int x,int y,int cnt,boolean chk) {
		
		resul=Math.max(cnt, resul);
		for (int i = 0; i < 4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			//범위 안에 있고 길이 더 낮아지는 경우
			if(inMap(nx, ny)&&visited[nx][ny]==false&&compare(map[x][y],map[nx][ny])) {
				visited[nx][ny]=true;
				DFS(nx,ny,cnt+1,chk);
				visited[nx][ny]=false;
			}
			//범위 안에 있고&&길의 차이가 K이하&& K~1 낮혀보기
			else if(chk==false&&inMap(nx, ny)&&visited[nx][ny]==false&&!compare(map[x][y],map[nx][ny])&&map[nx][ny]-map[x][y]<K) {
					visited[nx][ny]=true;
					int tmp=map[nx][ny];
					map[nx][ny]=map[x][y]-1;
					DFS(nx,ny,cnt+1,true);
					visited[nx][ny]=false;
					map[nx][ny]=tmp;
			}
		}
	}
}
