package Algo;

import java.util.Scanner;

public class BOJ_0225_S3_2559_¼ö¿­2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) 
			arr[i] = sc.nextInt();
			
		int sum = 0;
		
		for(int i=0;i<K;i++) 
			sum+=arr[i];
		
		int res = sum;
		
		for(int i=K;i<N;i++) {
			sum+=arr[i]-arr[i-K];
			
			if(sum>res) res = sum;
		}
		System.out.println(res);
	}
}
