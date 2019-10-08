import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class ·Î¶Ç {

	static int k;
	static Scanner sc = new Scanner(System.in);
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			k = sc.nextInt();
			if (k != 0) {
				arr = new int[k];
				for (int i = 0; i < k; i++) {
					arr[i] = sc.nextInt();
				}
				System.out.println(Arrays.toString(arr));
				Queue<Integer>q=new PriorityQueue<>();
				
				for (int i = 0; i < (1 << k); i++) {
					for (int j = 0; j < k; j++) {
						if (((1 << j) & i) != 0) {
							q.add(arr[j]);
						}
					}
					System.out.println(q.toString());
				}
			} else if (k == 0)
				break;
		}
	}
}
