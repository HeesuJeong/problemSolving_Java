package 재귀함수;

import java.util.Arrays;


public class 재귀총집합 {

	static int[] arr= {1,2,3,4};
	static boolean[] visited;
	static int[] resul;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		visited=new boolean[arr.length];
		//4개 중에 2개 뽑는 연습입니당
		resul=new int[2];
		System.out.println("순열 결과");
		perm(0);
		System.out.println("조합 결과");
		combi(0,0);
		System.out.println("중복 순열 결과");
		re_perm(0);
		System.out.println("중복 조합 결과");
		re_combi(0,0);
		System.out.println("powerSet 결과");
		//순열에서 visited배열 사용했었기 때문에 다시 초기화
		Arrays.fill(visited, false);
		powerSet(0);
	}
	
	//순열은 인자가 하나!(출력 배열의 인덱스)=>arr의 인덱스는 for문을 통해 검사
	//순열의 기저는 하나!
	static void perm(int c) {
		if(c==resul.length) {
			System.out.println(Arrays.toString(resul));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			//방문한 적 없다면~
			if(visited[i]==false) {
				resul[c]=arr[i];
				visited[i]=true;
				perm(c+1);
				visited[i]=false; 
			}
		}
	}
	//조합은 인자가 두개(출력 배열의 인덱스/ arr 인덱스)
	//조합의 기저는 두개
	static void combi(int n,int c) {
		if(c==resul.length) {
			System.out.println(Arrays.toString(resul));
			return;
		}
		if(n==arr.length) return;
		
		resul[c]=arr[n];
		//arr의 다음 인자를
		//resul 배열에 담는경우!
		combi(n+1,c+1);
		//resul 배열에 담지 않는 경우(c+1이 아니라는 것이 중요)
		combi(n+1,c);
	}
	//중복순열
	//순열이지만 visited 배열 필요없지용=>중복이 가능하기 때문에!
	static void re_perm(int c) {
		if(c==resul.length) {
			System.out.println(Arrays.toString(resul));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			resul[c]=arr[i];
			re_perm(c+1);
		}
	}
	//중복조합
	//인자 n과 for문의 i관계를 파악하는게 중요!
	static void re_combi(int n,int c) {
		if(c==resul.length) {
			System.out.println(Arrays.toString(resul));
			return;
		}
		for (int i = n; i < arr.length; i++) {
			resul[c]=arr[i];
			re_combi(i, c+1);
		}
	}
	//부분집합 
	//arr배열 하나씩 검사할 인자 idx 하나만 필요!
	//순열과 함께 visited 배열이 필요한 부분집합구하기!
	//true,false로 셋팅하고=> arr모든 원소의 셋팅이 끝나면 true인 값만 출력하기
	static void powerSet(int idx) {
		//출력결과는 2^4=16개 이다!(단 모두  false인 경우는 눈에 안 보일 수 있습니다!)
		if(idx==arr.length) {
			for (int i = 0; i < arr.length; i++) {
				if(visited[i]==true) System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		visited[idx]=true;
		powerSet(idx+1);
		visited[idx]=false;
		powerSet(idx+1);
	}
}
