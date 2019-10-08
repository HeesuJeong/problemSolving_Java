import java.util.Arrays;
import java.util.Scanner;

public class 다양성측정 {

	static int[] arr=new int[10];
	static Scanner sc=new Scanner(System.in);
	static int T;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int num=sc.nextInt();
			Arrays.fill(arr, 0);
			while(num>0) {
				arr[num%10]++;
				num/=10;
			}
			
			int cnt=0;
			for (int i = 0; i < 10; i++) {
				if(arr[i]!=0) cnt++; 
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}

}
