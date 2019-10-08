
import java.util.LinkedList;
import java.util.Scanner;

public class 배열돌리기4 {

	static int N;
	static int M;
	static int K;
	static Scanner sc = new Scanner(System.in);
	static int[][] arr;
	static int[][] tmp;

	static class info {
		int r;
		int c;
		int s;

		public info(int r, int c, int s) {
			// TODO Auto-generated constructor stub
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	// rcs 저장할 리스트
	static LinkedList<info> li;
	static boolean[] visited;
	static int resul = Integer.MAX_VALUE;
	static info[] tmpArr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N + 1][M + 1];
		tmp = new int[N + 1][M + 1];
		li = new LinkedList<info>();
		visited = new boolean[K];
		tmpArr = new info[K];
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < K; i++) {
			li.add(new info(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		perm(0);
		System.out.println(resul);
	}

	static void copyArr() {
		for (int i = 1; i <= N; i++) {
			tmp[i] = arr[i].clone();
		}
	}

	// rotation 되는지
	static boolean chk(int sx, int sy, int ex, int ey) {
		return ex - sx >= 1 && ey - sy >= 1;
	}

	static void printTmp() {
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=M; j++) {
				System.out.print(tmp[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void rotate(int r, int c, int s) {
		int startX = r - s;
		int startY = c - s;
		int endX = r + s;
		int endY = c + s;

		//rotation 가능하면 돌리기ㅣㅣ
		while (chk(startX, startY, endX, endY)) {
			// ->
			int temp1 = tmp[startX][endY];
			for (int i = endY; i > startY; i--) {
				tmp[startX][i] = tmp[startX][i-1];
			}
//			System.out.println("===위=======");
//			printTmp();
			// V
			int temp2=tmp[endX][endY];
			for (int i = endX; i > startX; i--) {
				tmp[i][endY] = tmp[i-1][endY];
			}
			tmp[startX+1][endY]=temp1;
//			System.out.println("===오른쪽=======");
//			printTmp();
			// <-
			int temp3=tmp[endX][startY];
			//arr[endX][endY]=temp2;
			for (int i = startY; i <endY; i++) {
				tmp[endX][i] = tmp[endX][i+1];
			}
			tmp[endX][endY-1]=temp2;
//			System.out.println("===아래=======");
//			printTmp();
			// ^
			for (int i = startX; i <endX; i++) {
				if(i==endX) tmp[i-1][startY]=temp3;
				else tmp[i][startY] = tmp[i+1][startY];
			}
			tmp[endX-1][startY]=temp3;
//			System.out.println("===왼쪽=======");
//			printTmp();
			startX++;
			startY++;
			endX--;
			endY--;
			
		}

	}


	static void perm(int c) {
		if (c == li.size()) {
			copyArr(); // 배열복사
			for (int i = 0; i < tmpArr.length; i++) {
				rotate(tmpArr[i].r, tmpArr[i].c, tmpArr[i].s);
			}
			int min = findMin();
//			System.out.println("resul은 "+resul);
//			printTmp();
			resul = Math.min(resul, min);
			return;
		}
		for (int i = 0; i < li.size(); i++) {
			if (visited[i] == false) {
				visited[i] = true;
				//System.out.println(tmpArr.length);
				//System.out.println("왜냐오오오오오옹 "+c);
				tmpArr[c] = li.get(i);
				perm(c + 1);
				visited[i] = false;
			}
		}
	}

	static int findMin() {
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <=N; i++) {
			sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += tmp[i][j];
			}
			min = Math.min(sum, min);
		}
		return min;
	}
}
