package jungol;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class ≥√¿Â∞Ì {
	static int N;
	static Scanner sc=new Scanner(System.in);
	static class info{
		int min;
		int max;
		public info(int min,int max) {
			// TODO Auto-generated constructor stub
			this.min=min;
			this.max=max;
		}
	}
	static LinkedList<info> li;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		li=new LinkedList<>();
		N=sc.nextInt();
		for (int i = 0; i <N; i++) {
			li.add(new info(sc.nextInt(),sc.nextInt()));
		}
		Collections.sort(li,new Comparator<info>() {

			@Override
			public int compare(info o1, info o2) {
				// TODO Auto-generated method stub
				return o2.min-o1.min;
			}
		});
		
		for (int i = 0; i <li.size(); i++) {
			System.out.println(li.get(i).min+" "+li.get(i).max);
		}
		System.out.println("\n\n");
		
		int resul=0;
		int sz=li.size();
		for (int i = 0; i <li.size(); i++) {
			//System.out.println(li.get(i).min+" "+li.get(i).max);
			int select=li.get(i).min;
			resul++;
			int minusCnt=0;
			for (int j = 0; j <li.size(); j++) {
				if(select>=li.get(j).min&&select<=li.get(j).max) {
					li.remove(j);
					j--;
				}
			}
			i--;
		}
		System.out.println(resul);
	}

}
