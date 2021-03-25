package Algo;

import java.util.Scanner;

public class BOJ_0325_S2_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] num = new int[N];
		int[] LIS = new int[N];
		
		for(int i=0;i<N;i++)
			num[i] = sc.nextInt();
		
		int max = 0;
		for(int i=0;i<N;i++) {
			LIS[i] = 1;
			for(int j=0;j<i;j++) {
				if(num[j]<num[i] && LIS[j]+1>LIS[i])
					LIS[i] = LIS[j]+1;
			}
			if(max<LIS[i])
				max = LIS[i];
		}
		System.out.println(max);
	}
}
