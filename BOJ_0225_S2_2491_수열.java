package Algo;

import java.util.Scanner;

public class BOJ_0225_S2_2491_¼ö¿­ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int count = 1,res = 1;
		for(int i=0;i<N;i++) 
			arr[i] = sc.nextInt();
		
		for(int i=0;i<N-1;i++) {
			if(arr[i]<=arr[i+1]) {
				count++;
				if(count>res) res=count;
			}
			else
				count = 1;
		}
		count = 1;
		for(int i=0;i<N-1;i++) {
			if(arr[i]>=arr[i+1]) {
				count++;
				if(count>res) res=count;
			}
			else
				count = 1;
		}
		
		System.out.println(res);
	}
}
