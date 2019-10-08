import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소3 {

	static int N;
	static int M;
	static Scanner sc = new Scanner(System.in);
	static int[][] map;
	final static int[] dx = { -1, 1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };
	static Queue<Point> q = new LinkedList<Point>();
	static Queue<Point> newQ = new LinkedList<Point>();
	final static int defaultMAX = 1000000;
	static int resul = defaultMAX;
	static int cnt;
	static int[][] temp;
	
	//0빈칸 1벽 2바이러스가능위치
	//M개를 활성상태로 변경 => 활성만나면 비활성도 활성으로
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
