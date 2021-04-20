package Algo;

import java.util.Scanner;

public class BOJ_0420_S3_6591_ÀÌÇ×¼î´Ù¿î {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		while(true) {
			long N = sc.nextLong();
			long K = sc.nextLong();
			
			if(N==0 && K==0) break;
			
			long res = 1;
			
			if(K>N-K) K = N-K;
			
			for(long i=1;i<=K;i++) {
				res *= N--;
				res /= i;
			}
			System.out.println(res);
		}
	}
}
