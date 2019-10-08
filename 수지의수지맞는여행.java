package 재귀함수;

import java.util.Arrays;
import java.util.Scanner;

public class 수지의수지맞는여행 {

	static int R;
	static int C;
	static char[][] arr;
	static boolean[] alphabet=new boolean[26];
	final static int[] dx= {-1,1,0,0};
	final static int[] dy= {0,0,-1,1};
	static int TC;
	static Scanner sc=new Scanner(System.in);
	static int result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			result=0;
			Arrays.fill(alphabet,false);
			R=sc.nextInt();
			C=sc.nextInt();
			
			arr=new char[R+2][C+2];
			
			for (int i = 1; i <= R; i++) {
				String str=sc.next();
				for (int j = 0; j < C; j++) {
					arr[i][j+1]=str.charAt(j);
				}
			}
			alphabet[arr[1][1]-'A']=true;
			//System.out.println(arr[1][1]);
			recur(1,1,1);
			System.out.println("#"+tc+" "+result);
		}//tc
	}
	static void recur(int x,int y,int cnt) {
		for (int i = 0; i < 4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(inArr(nx, ny)&&alphabet[arr[nx][ny]-'A']==false) {
				//System.out.println(arr[nx][ny]);
				alphabet[arr[nx][ny]-'A']=true;
				recur(nx,ny,cnt+1);
				alphabet[arr[nx][ny]-'A']=false;
			}
			else {
				result=Math.max(result, cnt);
			}
		}
	}
	
	static boolean inArr(int x,int y) {
		return x>=1&&x<=R&&y>=1&&y<=R;
	}
}
