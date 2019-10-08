package Àç±ÍÇÔ¼ö;

public class °ÅµìÁ¦°ö {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(pow(2,4));
	}
	static int pow(int a,int b) {
		if(b==1) {
			return a;
		}
		int tmp=pow(a,b/2);
		if(b%2==1) return tmp*tmp*a;
		else return tmp*tmp;
	}
}
