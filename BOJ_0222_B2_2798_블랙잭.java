package Algo;

import java.util.Scanner;

public class BOJ_0222_B2_2798_∫Ì∑¢¿Ë {
	
	static int N,M,diff;
	static int[] arr,num;
	static int res = 0,min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		num = new int[3];
		for(int i=0;i<N;i++) 
			arr[i]=sc.nextInt();
		
		com(0,0);
		
		System.out.println(res);
	}
	
	private static void com(int cnt,int start) {
		if(cnt == 3) {
			int sum=0;
			diff=0;
			for(int i=0;i<3;i++) {
				sum+=arr[num[i]];
			}
			diff = M - sum;
			if(diff<0)
				return;
			
			if(min>diff) {
				min = diff;
				res = sum;
			}
			return;
		}
		
		for(int i=start;i<N;i++) {
			num[cnt]=i;
			com(cnt+1,i+1);
		}
	}
}
