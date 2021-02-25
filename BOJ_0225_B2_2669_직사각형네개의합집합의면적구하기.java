package Algo;

import java.util.Scanner;

public class BOJ_0225_B2_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int[][] map = new int[100][100];
		int[][] arr = new int[4][4];
		for(int i=0;i<4;i++) 
			for(int j=0;j<4;j++) 
				arr[i][j] = sc.nextInt();
				
		int sum = 0;
		
		for(int i=0;i<4;i++) {
			for(int a=arr[i][0];a<arr[i][2];a++) {
				for(int b=arr[i][1];b<arr[i][3];b++) {
					map[a][b] = 1;
				}
			}
		}
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]==1) sum++;
			}
		}
		
		System.out.println(sum);
	}
}
