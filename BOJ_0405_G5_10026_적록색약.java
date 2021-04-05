package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_0405_G5_10026_적록색약 {
	
	static int N;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] arr;
	static boolean[][] visit,visit2;
	static int res = 0,res2 = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.next());
		arr = new int[N][N];
		visit = new boolean[N][N];
		visit2 = new boolean[N][N];
		
		// R-1 G-2 B-3
		for(int i=0;i<N;i++) {
			String s = sc.next();
			for(int j=0;j<N;j++) {
				if(s.charAt(j)=='R') 
					arr[i][j]=1;
				else if(s.charAt(j)=='G')
					arr[i][j]=2;
				else
					arr[i][j]=3;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]==false)
					bfs1(i,j,arr[i][j]);
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit2[i][j]==false)
					bfs2(i,j,arr[i][j]);
			}
		}
		
		System.out.println(res+" "+res2);
	}
	
	private static void bfs1(int r,int c,int tmp) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r,c,tmp});
		visit[r][c] = true;
		res++;
		
		while(!queue.isEmpty()) {
			int[] a = queue.poll();
			int x = a[0];
			int y = a[1];
			int tp = a[2];
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || arr[nx][ny]!=tp || visit[nx][ny]==true) continue;
			
				queue.add(new int[] {nx,ny,tp});
				visit[nx][ny] = true;
			}
		}
	}
	
	private static void bfs2(int r,int c,int tmp) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r,c,tmp});
		visit2[r][c] = true;
		res2++;
		
		while(!queue.isEmpty()) {
			int[] a = queue.poll();
			int x = a[0];
			int y = a[1];
			int tp = a[2];
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || visit2[nx][ny]==true) continue;
				
				if(tp==1 || tp==2) {
					if(arr[nx][ny]==3) 
						continue;
				}
				if(tp==3) {
					if(arr[nx][ny]!=3)
						continue;
				}
				queue.add(new int[] {nx,ny,tp});
				visit2[nx][ny] = true;
			}
		}
	}
}
