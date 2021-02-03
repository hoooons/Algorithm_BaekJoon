package Algo;

import java.util.Scanner;

public class A_0201_S5_2563_»öÁ¾ÀÌ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[100][100];
		int T = Integer.parseInt(sc.next());
		int count = 0;
		for(int t=0;t<T;t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for(int i=a;i<a+10;i++) {
				for(int j=b;j<b+10;j++) {
					if(arr[i][j]==1)
						continue;
					
					arr[i][j]=1;
					count++;
				}
			}	
		}
		
		System.out.println(count);
	}
}
