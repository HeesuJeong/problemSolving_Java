import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _1로만들기 {

	static int[] arr= {1,2,3};
	static int N;
	static Scanner sc=new Scanner(System.in);
	static int CNT;
	static int resul=10000;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		N=sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		recur(N,0);
		System.out.println(resul);
	}
	static void recur(int r,int c) {
		if(r==1) {
			resul=Math.min(c, resul);
			return;
		}
		//else if(r<0) return;
		
		for (int i = 0; i < arr.length; i++) {
			if(i==0&&(r%3==0)) {
				int tmpR=r/3;
				recur(tmpR,c+1);
			}
			else if(i==1&&(r%2==0)) {
				int tmpR=r/2;
				recur(tmpR,c+1);
			}else if(i==2) {
				recur(r-1,c+1);
			}
		}
	}
}
