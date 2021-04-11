package Algo;

import java.util.Scanner;

public class BOJ_0411_G4_1976_여행가자 {
	
	static int N,M;
	static int[] arr;
	static String str = "YES";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		make();
	
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				int tmp = sc.nextInt();
				
				if(tmp==1) {
					union(i,j);
				}
			}
		}
		
		int res = 0;
		for(int i=0;i<M;i++) {
			int tmp = sc.nextInt();
			if(res == 0 ) {
				res = find(tmp);
				continue;
			}
			else {
				if(res == find(tmp))
					continue;
				else if(res != find(tmp)) {
					str = "NO";
					break;
				}
			}
		}
		
		System.out.println(str);
	}
	private static void make() {
		for(int i=1;i<N+1;i++) {
			arr[i] = i;				// i의 부모 i로 셋팅
		}
	}
	
	private static int find(int a) {
		if(arr[a]==a) {
			return a;
		}
		else {
			return arr[a] = find(arr[a]);
		}
	}
	
	private static void union(int a, int b) {
		arr[find(a)] = find(b);
	}
}
