package Algo;

import java.util.Scanner;

public class BOJ_0426_S3_9461_파도반수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int a = sc.nextInt();
			long[] arr = new long[101];
			
			arr[0] = 0;
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 1;
			
			for(int i=4;i<=100;i++) {
				arr[i] = arr[i-2] + arr[i-3];
			}
			System.out.println(arr[a]);
		}
	}
}
