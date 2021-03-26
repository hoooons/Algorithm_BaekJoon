package Algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_0326_G5_14502_연구소 {
	static int N,M,res;
	static int[][] arr;
	static List<int[]> list = new LinkedList<>();
	static Queue<int[]> queue = new LinkedList<>();
	static boolean[][] ans;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		ans = new boolean[N][M];
		
		for(int i=0;i<N;i++)		// 입력받기  (1->벽, 2->바이러스)
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();	
				if(arr[i][j]!=0) ans[i][j]=true;
			}
		res = 0;
		
		com(0,0);
		System.out.println(res);
	}
	private static void com(int cnt, int start) {
		if(cnt==3) {
			bfs();
			
			return;
		}
		
		for(int i=start;i<N*M;i++) {
			if(cnt!=list.size()) {
				while(cnt!=list.size()) {
					list.remove(list.size()-1);
				}
			}
			int x = i/M;
			int y = i%M;
			if(arr[x][y]!=0) continue;
			list.add(new int[] {x,y});
			com(cnt+1,i+1);
		}
	}
	
	private static void bfs() {
		boolean[][] visit = new boolean[N][M];
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) {
				visit[i][j] = ans[i][j];
				if(arr[i][j]==2) {
					queue.add(new int[] {i,j});
				}
			}
		for(int i=0;i<3;i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			visit[x][y] = true;
		}
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];
			
			for(int i=0;i<4;i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M || arr[nr][nc]!=0 || visit[nr][nc]==true) continue;
				
				visit[nr][nc] = true;
				queue.add(new int[] {nr,nc});
			}
		}
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(visit[i][j] == false) {
					cnt++;
				}
			}
		}
		if(cnt>res) res = cnt;
	}
}

