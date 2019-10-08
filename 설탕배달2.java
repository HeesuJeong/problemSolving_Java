import java.util.Scanner;

//중복조합 아니고 그냥 반복문으로는 풀 수 없는 문제이다!
//안 되는 코드입니당
public class 설탕배달2 {

	static int input;
	static Scanner sc = new Scanner(System.in);
	static int[] arr = { 3, 5 };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = sc.nextInt();
		
		int cnt=0;
		int tmp=input;
		while(tmp%5==0) {
			tmp%=5;
			cnt++;
		}
		while(tmp%3==0) {
			tmp%=3;
			cnt++;
		}
		if(cnt>0)System.out.println(cnt);
		else System.out.println("-1");
	}

}
