
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 구슬탈출222 {
	
	static class pos{
		int Rr, Rc, Br, Bc, num;
		public pos(int rr, int rc, int br, int bc, int num) {
			this.Rr = rr;
			this.Rc = rc;
			this.Br = br;
			this.Bc = bc;
			this.num = num;
		}
		
	}
	static int or=0, oc=0;
	static char[][] map = null;
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		map = new char[H+2][W+2];
		
		int rr=0, rc=0, br=0, bc=0;
		for (int i = 1; i <= H; i++) {
			String str = sc.next();
			for (int j = 1; j <= W; j++) {
				map[i][j] = str.charAt(j-1);
				if(map[i][j] == 'B') {
					br = i;
					bc = j;
					map[i][j] = '.';
				}
				else if(map[i][j] == 'R') {
					rr = i;
					rc = j;
					map[i][j] = '.';
				}
				else if(map[i][j] == 'O') {
					or = i;
					oc = j;
					map[i][j] = '.';
				}
			}
		}
		
		
		
		Queue<pos> list = new LinkedList<pos>();
		list.add(new pos(rr, rc, br, bc, 0));
		
		int cnt = 0;
		boolean nothing = true;
		loop : while(!list.isEmpty()) {
			rr = list.peek().Rr;
			rc = list.peek().Rc;
			br = list.peek().Br;
			bc = list.peek().Bc;
			cnt = list.poll().num;
			
			if(cnt>=10) {
				cnt= -2;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int ry = rr + delta[i][0];
				int rx = rc + delta[i][1];
				
				int by = br + delta[i][0];
				int bx = bc + delta[i][1];
				
				if(ry==by && rx==bx) continue;
				
				int[] finish = new int[4];
				if(map[ry][rx]=='.' || map[by][bx]=='.') { //둘 중 하나라도 움직일 수 잇으면 이동
					finish = move(i, rr, rc, br, bc);
					if(finish[0]== -1) {//빨강이 성공
                        nothing = false;
						break loop;
					}
					if(finish[0]!=-2) { //빨강도 파랑도 모두 실패했을때
						list.add(new pos(finish[0], finish[1], finish[2], finish[3], cnt+1));
					}
				}
			}
		}
		//파랑이 성공
		if(nothing) cnt = -2;
		System.out.println(cnt+1);
		
	}
	static int[] move(int i, int Red_r, int Red_c, int Brue_r, int Brue_c) {
		int[] finish = new int[4];
		int tmp_rr = Red_r;
		int tmp_rc = Red_c;
		int tmp_br = Brue_r;
		int tmp_bc = Brue_c;
		
		boolean flagR = false, flagB = false;
		while(map[Red_r + delta[i][0]][Red_c + delta[i][1]] == '.') {
			Red_r += delta[i][0];
			Red_c += delta[i][1];
			if(Red_r==or && Red_c==oc) flagR = true;
		}
		while(map[Brue_r + delta[i][0]][Brue_c + delta[i][1]] == '.') {
			
			Brue_r += delta[i][0];
			Brue_c += delta[i][1];
			
			if(Brue_r==or && Brue_c==oc) flagB = true;
		}
		if(flagR && !flagB) {
			finish[0] = -1;
			return finish;
		}
		
		else if(!flagR && flagB) {
			finish[0] = -2; //파랑만 빠졌을 때도 -2
			return finish;
		}
		
		if((Red_r==Brue_r)&&(Red_c==Brue_c)) {
			
			if(flagB&&flagR) {
				finish[0] = -2; //둘 다 빠졌을 때도 -2
				return finish;
			}
			
			switch(i) {
			case 0:
				if(tmp_rr < tmp_br) Brue_r++;
				else Red_r++;
				break;
			case 1:
				if(tmp_rr < tmp_br)	Red_r--;
				else Brue_r--;
				break;
			case 2:
				if(tmp_rc < tmp_bc) Brue_c++;
				else Red_c++;
				break;
			case 3:
				if(tmp_rc < tmp_bc) Red_c--;
				else Brue_c--;
				break;
			} 
			
		}
		
		finish[0] = Red_r;
		finish[1] = Red_c;
		finish[2] = Brue_r;
		finish[3] = Brue_c;
		
		return finish;
	}
}