package Algo;

import java.util.Scanner;

public class BOJ_0225_S5_2578_ºù°í {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[5][5];
		
		for(int i=0;i<5;i++) 
			for(int j=0;j<5;j++)
				arr[i][j] = sc.nextInt();
			
		for(int i=0;i<25;i++) {
			int bingo = 0;
			
			int call = sc.nextInt();
			
			for(int a=0;a<5;a++)
				for(int b=0;b<5;b++) {
					if(arr[a][b]==call)
						arr[a][b] = 0;
				}
			
			for(int c=0;c<5;c++) {
				for(int r=0;r<5;r++) {
					if(arr[r][c]!=0) break;
					if(r==4) bingo++;
				}
			}
			for(int r=0;r<5;r++) {
				for(int c=0;c<5;c++) {
					if(arr[r][c]!=0) break;
					if(c==4) bingo++;
				}
			}
			for(int a=0;a<5;a++) {
				if(arr[a][a]!=0) break;
				if(a==4) bingo++;
			}
			int a=4,b=0;
			for(int k=0;k<5;k++) {
				if(arr[a][b]!=0) break;
				if(k==4) bingo++;
				a--;
				b++;
			}
			
			if(bingo>=3) {
				System.out.println(i+1);
				break;
			}
			
		}
		
	}
}
