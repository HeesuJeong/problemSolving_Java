
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 아맞다우산 {
	static char[][] arr;
	static int N;
	static int M;
	static ArrayList<Point> li;
	static boolean[] visited;
	static boolean[][] visitedBFS;
	static Point start;
	static Point end;
	static Scanner sc = new Scanner(System.in);
	static int resul = 10000;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Point> q= new LinkedList<Point>();
	static int plus;
	static String str;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = sc.nextInt();
		M = sc.nextInt();
		arr=new char[M][N];
		visitedBFS=new boolean[M][N];
		
		li = new ArrayList<>();
		int stuffNum = 0;

		for (int i = 0; i < M; i++) {
			str = sc.next();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				arr[i][j]=c;
				if (c == 'S') {
					start = new Point(i, j);
				} else if (c == 'E') {
					end = new Point(i, j);
				} else if (c == 'X') {
					Point tmp = new Point(i, j);
					li.add(tmp);
					stuffNum++;
				}
			}
		}

		visited = new boolean[stuffNum];

		//Arrays.fill(visited, false);
		recur(0, start.x, start.y, 0);
		System.out.println(resul);
	}

	//물건들 순서 정하는 순열
	static void recur(int c, int x, int y, int sum) {
		if (c == li.size() ) {
			sum+=BFS(x,y,end.x,end.y);
			q.clear();
			for (int j = 0; j < arr.length; j++) {
				Arrays.fill(visitedBFS[j], false);
			}
			resul = Math.min(sum, resul);
			return;
		}
		for (int i = 0; i < li.size(); i++) {
			if (visited[i] == false) {
				plus=BFS(x,y,li.get(i).x,li.get(i).y);
				q.clear();
				for (int j = 0; j < arr.length; j++) {
					Arrays.fill(visitedBFS[j], false);
				}
				visited[i] = true;
				recur(c + 1, li.get(i).x,li.get(i).y, sum+plus);
				visited[i] = false;
			}
		}
	}

	static boolean inArr(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}

	//시작점,끝점 알 때 최단거리 구하기
	static int BFS(int sx, int sy, int ex, int ey) {
		q.add(new Point(sx, sy));
		visitedBFS[sx][sy]=true;
		int step = 0;
		while (!q.isEmpty()) {
			int sz = q.size();
			for (int s = 0; s < sz; s++) {
				Point np = q.poll();
				if(np.x==ex&&np.y==ey) {
					return step;
				}
				for (int i = 0; i < 4; i++) {
					int nx = np.x + dx[i];
					int ny = np.y + dy[i];
					if (inArr(nx, ny) && arr[nx][ny] != '#'&&visitedBFS[nx][ny]==false) {
						q.add(new Point(nx, ny));
						visitedBFS[nx][ny]=true;
					}
				}
			}
			step++;
		}
		return step;
	}

}
