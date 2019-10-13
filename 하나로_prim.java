package 토요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 하나로_prim {

	static int[][] posi;
	static double E;
	static ArrayList<info>[] list;
	static class info{
		int dest;
		double weight;
		public info(int dest,double weight) {
			// TODO Auto-generated constructor stub
			this.dest=dest;
			this.weight=weight;
		}
	}
	static PriorityQueue<info> pq;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		//입력부분
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=TC; tc++) {
			int N=Integer.parseInt(br.readLine());
			posi=new int[N][2]; //[][0] x좌표 [][1] y좌표
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				posi[i][0]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				posi[i][1]=Integer.parseInt(st.nextToken());
			}
			E=Double.parseDouble(br.readLine());
			
			//prim
			visited=new boolean[N];
			pq=new PriorityQueue<>(new Comparator<info>() {

				@Override
				public int compare(info o1, info o2) {
					// TODO Auto-generated method stub
					return Double.compare(o1.weight,o2.weight);
				}
			});
			
			list=new ArrayList[N];
			for (int i = 0; i < list.length; i++) {
				list[i]=new ArrayList<>();
			}
			for (int i = 0; i < posi.length; i++) {
				for (int j = i+1; j < posi.length; j++) {
					double tmp=Math.pow(posi[i][0]-posi[j][0], 2)+Math.pow(posi[i][1]-posi[j][1], 2);
					tmp*=E;
					list[i].add(new info(j,tmp));
					list[j].add(new info(i,tmp));
				}
			}
			//mst만들기
			pq.addAll(list[0]);
			visited[0]=true;
			int cnt=1; //정점의 수
			double result=0;
			while(cnt<N) {
				info tmp=pq.poll();
				if(visited[tmp.dest]==false) {
					pq.addAll(list[tmp.dest]);
					visited[tmp.dest]=true;
					cnt++;
					result+=tmp.weight;
				}
			}
			System.out.println("#"+tc+" "+(long)Math.round(result));
		}//tc
	}

}
