package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_0304_S2_1250_DFS¿ÍBFS {
	
	static int[][] arr;
	static int N,M,V;
	static int res=0;
	static boolean[] answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		arr = new int[N+1][N+1];
		answer = new boolean[N+1];
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;
		}
		
		
		dfs(V);
		System.out.println();
		bfs(V);
	}
	
	static private void bfs(int current) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] ans = new boolean[N+1];
		queue.offer(current);
		ans[current]=true;
		System.out.print(current+" ");
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			for(int i=1;i<N+1;i++) {
				if((arr[tmp][i]==1 || arr[i][tmp]==1)&& ans[i]==false) {
					ans[i]=true;
					System.out.print(i+" ");
					queue.offer(i);
				}
			}
		}
		
	}
	
	static private void dfs(int current) {
		if(res==N)
			return;
		
		answer[V]=true;
		System.out.print(current+" ");
		res++;
		
		for(int i=1;i<N+1;i++) {
			if((arr[current][i]==1 || arr[i][current]==1) && answer[i]==false) {
				answer[i]=true;
				dfs(i);
			}
		}
	}
}
