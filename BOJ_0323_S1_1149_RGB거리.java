package Algo;

import java.util.Scanner;

public class BOJ_0323_S1_1149_RGB°Å¸® {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[N+1][4];
		for(int i=1;i<=N;i++) 
			for(int j=1;j<=3;j++)
				arr[i][j] = sc.nextInt();
		
		int[][] pick = new int[N+1][4];
		for(int i=1;i<=3;i++)
			pick[1][i] = arr[1][i];
		
		for(int i=2;i<=N;i++) {
			pick[i][1] = Math.min(pick[i-1][2], pick[i-1][3])+arr[i][1];
			pick[i][2] = Math.min(pick[i-1][1], pick[i-1][3])+arr[i][2];
			pick[i][3] = Math.min(pick[i-1][1], pick[i-1][2])+arr[i][3];
		}
		
		System.out.println(Math.min(pick[N][1], Math.min(pick[N][2], pick[N][3])));
	}
}
