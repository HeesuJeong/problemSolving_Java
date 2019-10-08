import java.util.LinkedList;
import java.util.Scanner;

public class 로마숫자만들기 {
	static int N;
	static int[] arr= {1,5,10,50};
	static boolean[] visited=new boolean[1001];
	static String str;
	static int cnt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=new Scanner(System.in).nextInt();
		recur(0,0,0);
		System.out.println(cnt);
	}

	static void recur(int n,int c,int sum) {
		if(c==N) {
			if(visited[sum]==false) {
				cnt++;
				visited[sum]=true;
			}
			return;
		}
		
		for (int i = n; i < arr.length; i++) {
				int tmp=arr[i];
				recur(i,c+1,sum+tmp);
		}
	}
}
