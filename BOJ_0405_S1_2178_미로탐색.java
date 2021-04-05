package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_0405_S1_2178_¹Ì·ÎÅ½»ö {
	
	static int N,M;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] arr;
	static int[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.next());
		M = Integer.parseInt(sc.next());
		
		arr = new int[N][M];
		visit = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String s = sc.next();
			for(int j=0;j<M;j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		
		bfs(0,0);
		
		System.out.println(visit[N-1][M-1]);
	}
	
	private static void bfs(int r,int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r,c});
		visit[r][c] = 1;
		
		while(!queue.isEmpty()) {
			int[] a = queue.poll();
			
			int x = a[0];
			int y = a[1];
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || arr[nx][ny]==0) continue;
				
				if(visit[nx][ny]==0) {
					visit[nx][ny] = visit[x][y] + 1;
					queue.add(new int[] {nx,ny});
					continue;
				}
				else if(visit[nx][ny]!=0) {
					if(visit[x][y]+1 >= visit[nx][ny])
						continue;
					else if(visit[x][y]+1<visit[nx][ny]) {
						visit[nx][ny] = visit[x][y]+1;
						queue.add(new int[] {nx,ny});
						continue;
					}
				}
			}
		}
	}
}
