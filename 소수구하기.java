import java.util.Scanner;

public class �Ҽ����ϱ� {

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
	
	//2�ǹ�� 4,6,8,10,12.14,16,18,20,22
	//3�ǹ�� 6,9,12,15,18,21,24,27
	//4�� ��� 8,12,16,20,24
	//5�� ��� 10,15,20,25
	//6�� ��� 12,18,24
	//7�� ��� 14,21,28
	//8�� ��� 16,24,32
	//9�� ��� 18,27
	//10�� ��� 20....
	//2,3,5,7,
	//11�� ��� 22,33,44
	//12�� ��� 24,36,48
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		M=sc.nextInt();
		N=sc.nextInt();
		arr=new boolean[N+1];
		
		find(M,N);
		//1�� �Ҽ��� �ƴϴ�!!!!
		arr[1]=true;
		for (int i = M; i <=N; i++) {
			if(arr[i]==false) System.out.println(i);
		}
	}

}
