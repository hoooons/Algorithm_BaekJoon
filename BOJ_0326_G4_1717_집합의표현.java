package Algo;

import java.util.Scanner;

public class BOJ_0326_G4_1717_집합의표현 {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N+1];
		make();
		
		for(int i=0;i<M;i++) {
			int pick = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(pick==0) {
				union(a,b);
			}
			else {
				if(search(a,b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
	// 집합을 만듬
	private static void make() {
		for(int i=0;i<=N;i++) {
			arr[i] = i;
		}
	}
	
	private static int find(int a) {
		if(arr[a] == a) {
			return a;
		}
		return arr[a] = find(arr[a]);
	}
	
	private static void union(int a, int b) {
		if(arr[a]==arr[b])
			return;
		else
			arr[arr[b]] = arr[a];
	}
	
	private static boolean search(int a, int b) {
		if(find(arr[a])==find(arr[b]))
			return true;
		else
			return false;
	}
}
