import java.util.Scanner;

//�ߺ����� �ƴϰ� �׳� �ݺ������δ� Ǯ �� ���� �����̴�!
//�� �Ǵ� �ڵ��Դϴ�
public class �������2 {

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
