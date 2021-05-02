package Algo;

import java.util.Scanner;

public class BOJ_0502_B2_2846_오르막길 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) 
			arr[i] = sc.nextInt();
		
		int[] res = new int[N];
		int tmp = arr[0];
		int idx = 0;
		for(int i=1;i<N;i++) {
			if(arr[i]<=tmp) {		// 초기값 변경
				tmp = arr[i];
				res[i] = 0;
				idx = i;
				continue;
			}
			else if(arr[i]>tmp) {
				res[i] = arr[i] - arr[idx];
				tmp = arr[i];
			}
		}
		int max = 0;
		for(int i=0;i<N;i++) {
			if(max<res[i])
				max = res[i];
		}
		System.out.println(max);
	}
}
