package 토요일;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS {
	static int N;//정점의 수
	static int M;//간선의 수
	static boolean[] visited;
	static int[][] map;
	static int start;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		start=sc.nextInt();
		map=new int[N+1][N+1];
		visited=new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int tmp1=sc.nextInt();
			int tmp2=sc.nextInt();
			map[tmp1][tmp2]=1;
			map[tmp2][tmp1]=1;
		}
		
		//dfs
		
		visited[start]=true;
		DFS(start);
		System.out.println();
		//bfs
		
		Arrays.fill(visited, false);
		visited[start]=true;
		BFS(start);
		
	}

	private static void BFS(int x) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<>();
		q.add(x);
		System.out.print(x+" ");
		while(!q.isEmpty()) {
			int tmp=q.poll();
			for (int i = 1; i <=N; i++) {
				if(visited[i]==false&&map[tmp][i]==1) {
					visited[i]=true;
					q.add(i);
					System.out.print(i+" ");
				}
			}
		}
	}

	private static void DFS(int x) {
		// TODO Auto-generated method stub
		System.out.print(x+" ");
		for (int i = 1; i <=N; i++) {
			if(!visited[i]&&map[x][i]==1) {
				visited[i]=true;
				DFS(i);
			}
		}
	}
	
	
}
