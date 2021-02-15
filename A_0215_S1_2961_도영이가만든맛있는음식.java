package Algo;

import java.util.Scanner;

public class A_0215_S1_2961_도영이가만든맛있는음식 {
	
	
	static int[] arr,arr2;
	static boolean[] ans;
	static int N,S=1,B=0,diff;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		arr2 = new int[N];
		ans = new boolean[N];
		diff = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			arr2[i] = sc.nextInt();
		}
		
		sub(0);
		
		System.out.println(diff);
	}
	
	private static void sub(int cnt) {
		
		if(cnt == N) {
			int count = 0;
			S = 1;
			B = 0;
			for(int i=0;i<N;i++) {
				if(ans[i]==true) {
					S *= arr[i];
					B += arr2[i];
					count++;
				}
			}
			if(count==0)
				return;
			
			int tmp = Math.abs(S-B);
			
			if(tmp<diff)
				diff = tmp;
			
			return;
		}
		ans[cnt] = true;
		sub(cnt+1);
		ans[cnt] = false;
		sub(cnt+1);
	}
}
