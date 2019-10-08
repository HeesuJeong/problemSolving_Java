import java.util.Scanner;

public class º¸¹° {

	static Scanner sc=new Scanner(System.in);
	static int[] Aarr;
	static int[] Barr;
	static int N;
	static int[] tmp;
	static boolean visited[];
	static int resulMin=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=sc.nextInt();
		Aarr=new int[N];
		Barr=new int[N];
		tmp=new int[N];
		visited=new boolean[N];
		
		for (int i = 0; i < N; i++) {
			Aarr[i]=sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			Barr[i]=sc.nextInt();
		}
		perm(0);
		
		System.out.println(resulMin);
	}
	static void perm(int c) {
		if(c==tmp.length) {
			int sum=0;
			for (int i = 0; i < N; i++) {
				sum+=(tmp[i]*Barr[i]);
			}
			resulMin=Math.min(sum,resulMin);
			return;
		}
		for (int i = 0; i < Aarr.length; i++) {
			if(visited[i]==false) {
				visited[i]=true;
				tmp[c]=Aarr[i];
				perm(c+1);
				visited[i]=false;
			}
		}
	}

}
