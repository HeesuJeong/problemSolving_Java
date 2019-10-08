import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class 진기의최고급붕어빵 {

	static int T;
	static int N;
	static Scanner sc=new Scanner(System.in);
	static int M;
	static int K;
	static int cnt;
	static LinkedList<Integer> timeli;
	static int[] arr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T=sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			timeli=new LinkedList<>();
			arr=new int[11112];
			cnt=0;
			N=sc.nextInt();
			M=sc.nextInt();
			K=sc.nextInt();
			for (int i = 0; i < N; i++) {
				timeli.add(sc.nextInt());
			}
			Collections.sort(timeli,new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o1-o2;
				}
			});
			int input=0;
			for (int i = 0; i <=11111; i++) {
				if(i%M==0&&i!=0) {
					input+=K;
				}
				arr[i]=input;
			}
			boolean chk=false; //실패시 true
			for (int i = 0; i <timeli.size(); i++) {
				if(arr[timeli.get(i)]-cnt<=0) {
					//System.out.println("tc: "+tc+"번째에서 "+timeli.get(i)+"초에 온 사람이 못 먹었어");
					chk=true;
					break;
				}
				cnt++;
			}
			if(chk) System.out.println("#"+tc+" "+"Impossible");
			else System.out.println("#"+tc+" "+"Possible");
		}//tc
	}

}
