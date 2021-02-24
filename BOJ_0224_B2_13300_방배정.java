package Algo;

import java.util.Scanner;

public class BOJ_0224_B2_13300_πÊπË¡§ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] arr = new int[2][6];
		
		for(int i=0;i<N;i++) {
			int sex = sc.nextInt();
			int gr = sc.nextInt();
			
			arr[sex][gr-1]++;
		}
		
		int res = 0;
		
		for(int i=0;i<2;i++) {
			for(int j=0;j<6;j++) {
				int tmp = 0;
				while(arr[i][j]>0) {
					arr[i][j]-=K;
					res++;
				}
			}
		}
		
		System.out.println(res);
		
	}
}
