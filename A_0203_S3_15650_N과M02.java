package Algo;

import java.util.Scanner;

public class A_0203_S3_15650_N°úM02 {
	
	static int[] numbers;
	static int num;
	static int pick;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
		pick=sc.nextInt();
		
		numbers = new int[pick];
		com(0,1);	
	}
	
	static void com(int cnt,int start) {
		if(cnt==pick) {
			for(int n:numbers) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=num;i++) {
			
			numbers[cnt]=i;
			
			com(cnt+1,i+1);
		}
	}
}	
