package 금요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//disjoint set
public class 친구네트워크 {

	static int[] parents;
	static int[] cntArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			parents = new int[200001];
			cntArr = new int[200001];
			// makeset
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
				cntArr[i] = 1;
			}
			HashMap<String, Integer> set = new HashMap<>();
			int num = 0;
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				if (!set.containsKey(str1)) {
					set.put(str1, num++);
				}
				if (!set.containsKey(str2)) {
					set.put(str2, num++);
				}
				System.out.println(union(set.get(str1), set.get(str2)));
			} // 친구관계 한 줄 씩 들어옴
		} // tc
	}

	private static int union(int x, int y) {
		// TODO Auto-generated method stub
		int px = findSet(x);
		int py = findSet(y);
		//***********다른 집합인 경우에 루트 네트워크의 원소 수 갱신!!**********
		if (px != py) { 
			parents[px] = parents[py];
			cntArr[py] += cntArr[px];
			cntArr[px] = 1;
		}
		return cntArr[py];
	}

	private static int findSet(int x) {
		// TODO Auto-generated method stub
		if (x == parents[x])
			return x;
		return parents[x] = findSet(parents[x]);
	}

}
