package 토요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 하나로 {

	static int[][] posi;
	static double[][] infoArr;
	static int[] parents;
	static double E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
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
			
			parents=new int[N];
			infoArr=new double[(N*N-1)/2][3]; //시작섬,끝섬,가중치
			
			//크루스칼 표 완성하기
			int idx=0;
			for (int i = 0; i < posi.length; i++) {
				for (int j = i+1; j < posi.length; j++) {
					infoArr[idx][0]=i;
					infoArr[idx][1]=j;
					double tmp=Math.pow(posi[i][0]-posi[j][0],2)+Math.pow(posi[i][1]-posi[j][1],2);
					//System.out.println("tmp "+tmp);
					tmp*=E; //지불 비용
					infoArr[idx][2]=tmp;
					idx++;					
				}
			}
			//MST만들기
			for (int i = 0; i <parents.length; i++) {
				parents[i]=i;
			}
			//간선의 weight 작은 순으로 정렬
			Arrays.sort(infoArr,new Comparator<double[]>() {

				@Override
				public int compare(double[] o1, double[] o2) {
					// TODO Auto-generated method stub
					return Double.compare(o1[2], o2[2]);
				}
			});
		/*	for (int i = 0; i < infoArr.length; i++) {
				System.out.println(infoArr[i][0]+" "+infoArr[i][1]+" "+infoArr[i][2]);
			}*/
			double result=0;
			int cnt=0;
			for (int i = 0; i <infoArr.length; i++) {
				int px=(int)findSet((int)infoArr[i][0]);
				int py=(int)findSet((int)infoArr[i][1]);
				if(px!=py) {
					result+=infoArr[i][2];
					union(px,py);
					cnt++;
				}
				//간선의 수가 정점의수-1 이면 MST 완성
				if(cnt==N-1) break; 
			}
			System.out.println("#"+tc+" "+(long)Math.round(result));
		}//tc
	}
	
	private static void union(int px, int py) {
		// TODO Auto-generated method stub
		parents[px]=py;
	}

	private static int findSet(int x) {
		// TODO Auto-generated method stub
		if(x==parents[x]) return x;
		return parents[x]=findSet(parents[x]);
	}

}
