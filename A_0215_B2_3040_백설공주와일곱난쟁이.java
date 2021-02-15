package Algo;

import java.util.Scanner;
// 조합 문제
public class A_0215_B2_3040_백설공주와일곱난쟁이 {
	
	static int N = 9, pick=7;
	static int[] num,arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = new int[N];
		arr = new int[pick];
		
		for(int i=0;i<N;i++) 
			num[i] = sc.nextInt();
		
		com(0,0);
	}
	
	private static void com(int cnt, int start) {
		if(cnt == pick) {
			int sum=0;
			for(int i=0;i<pick;i++) {
				sum+=arr[i];
			}
			if(sum==100)
			{
				for(int i=0;i<pick;i++) {
					System.out.println(arr[i]);
				}
			}
			return;
		}
		for(int i=start;i<N;i++) {
			arr[cnt] = num[i];
			com(cnt+1,i+1);
		}
	}
}
