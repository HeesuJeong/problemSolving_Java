import java.util.Arrays;
import java.util.Scanner;

public class ��Ģ������ȿ���˻� {

	static int T=10;
	static Scanner sc=new Scanner(System.in);
	static char[] arr;
	static int nodeNum;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int tc = 1; tc <= T; tc++) {
			nodeNum=Integer.parseInt(sc.nextLine());
			arr=new char[nodeNum+1];
			for (int i = 1; i <= nodeNum; i++) {
				String str=sc.nextLine();
				String[] str2=str.split(" ");
				arr[i]=str2[1].charAt(0);
				//System.out.println(str.split(" ")[1].charAt(0));
			}
			boolean possible=true;
			for (int i = 1; i <=nodeNum; i++) {
				int lchild=i*2; int rchild=i*2+1;
				//�����ڽ�, ������ �ڽ� �� �ִµ� �����ڰ� �ƴ� ���
				if((lchild<=nodeNum)&&(rchild<=nodeNum)&&(arr[lchild]!='\0')&&(arr[rchild]!='\0')) {
					if(arr[i]!='+'&&arr[i]!='-'&&arr[i]!='*'&&arr[i]!='/') {
						possible=false;
						break;
					}
				}
				//�����ε� ���ڰ� �ƴѰ��
				if(lchild>nodeNum||lchild=='\0') {
					if(arr[i]=='+'||arr[i]=='-'||arr[i]=='*'||arr[i]=='/') {
						possible=false;
						break;
					}
				}
			}
			System.out.print("#"+tc+" ");
			if(possible) System.out.print("1");
			else System.out.print("0");
			System.out.println();
		}//tc
	}

}
