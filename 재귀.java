package ����Լ�;

import java.util.Arrays;

public class ��� {

	static int resul;
	static int[] arr= {1,3,5,7};
	static boolean[] visited=new boolean[arr.length];
	static int[] brr=new int[2];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combination(0,0);
		System.out.println("�ߺ�����");
		�ߺ�����(0);
		System.out.println("����");
		����(0);
	}

	static void combination(int n,int c) {
		if(c==brr.length) {
			System.out.println(Arrays.toString(brr));
			return;
		}
		if(n==arr.length) {
			return;
		}
		brr[c]=arr[n];
		combination(n+1,c+1);
		combination(n+1,c);
	}
	
	static void �ߺ�����(int c) {
		if(c==brr.length) {
			System.out.println(Arrays.toString(brr));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			brr[c]=arr[i];
			�ߺ�����(c+1);
		}
	}
	
	static void ����(int c) {
		if(c==brr.length) {
			System.out.println(Arrays.toString(brr));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(visited[i]==false) {
				visited[i]=true;
				brr[c]=arr[i];
				����(c+1);
				visited[i]=false;
			}
		}
	}
}
