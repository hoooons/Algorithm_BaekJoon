package Algo;

import java.util.Scanner;

public class BOJ_0328_G4_10422_°ýÈ£ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long[] arr = new long[5001];
		arr[0] = 1;
		arr[2] = 1;
		
		for(int i=4;i<5001;i++) {
			if(i%2==1) continue;
			for(int j=0;j<i;j++) {
				if(j%2==1) continue;
				arr[i] += arr[j]*arr[i-2-j];
				arr[i] %= 1000000007;
			}
		}
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int L = sc.nextInt();
			System.out.println(arr[L]);
		}
	
		
	}
}
