import java.util.Scanner;

public class 소수구하기 {

	static int M;
	static int N;
	static Scanner sc=new Scanner(System.in);
	static boolean[] arr;
	
	static void find(int start,int end) {
		for (int i = 2; i*i <= N; i++) {
			if(!arr[i]) {
				for (int j = 2; i*j <=N; j++) {
					arr[i*j]=true;
				}
			}
		}
	}
	
	//2의배수 4,6,8,10,12.14,16,18,20,22
	//3의배수 6,9,12,15,18,21,24,27
	//4의 배수 8,12,16,20,24
	//5의 배수 10,15,20,25
	//6의 배수 12,18,24
	//7의 배수 14,21,28
	//8의 배수 16,24,32
	//9의 배수 18,27
	//10의 배수 20....
	//2,3,5,7,
	//11의 배수 22,33,44
	//12의 배수 24,36,48
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		M=sc.nextInt();
		N=sc.nextInt();
		arr=new boolean[N+1];
		
		find(M,N);
		//1은 소수가 아니다!!!!
		arr[1]=true;
		for (int i = M; i <=N; i++) {
			if(arr[i]==false) System.out.println(i);
		}
	}

}
