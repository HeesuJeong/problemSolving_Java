
public class innerclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Outer().start();
		new staticOuter().start();
	}

}

class Outer {
	int a = 10;

	public void start() {
		new inner().plus();
		System.out.println(a);
	}

	class inner {
		public void plus() {
			a += 10;
		}
	}
}

class staticOuter{
	int a=10;
	static int b=20;
	
	public static void start() {
		new inner().plus();
	}
	
	static class inner{
		public static void plus() {
			//a+=10;
			b+=10;
		}
	}
}