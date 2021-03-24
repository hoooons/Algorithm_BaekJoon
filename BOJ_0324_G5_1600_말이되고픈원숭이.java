package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_0324_G5_1600_¸»ÀÌµÇ°íÇÂ¿ø¼þÀÌ {
	
	static int K,W,H;
	static int[][] arr;
	static int[][][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[] hx = {-1,-2,-2,-1,1,2,2,1};
	static int[] hy = {-2,-1,1,2,2,1,-1,-2};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		int res = Integer.MAX_VALUE;
		
		arr = new int[H][W];
		visit = new int[K+1][H][W];
		
		for(int i=0;i<H;i++)
			for(int j=0;j<W;j++)
				arr[i][j] = sc.nextInt();
		
		bfs(0,0,0);
	
		for(int i=0;i<K+1;i++) {
			if(visit[i][H-1][W-1]==0) continue;
			if(res>visit[i][H-1][W-1])
				res=visit[i][H-1][W-1];
		}
		if(res==Integer.MAX_VALUE) res=-1;
		if(W==1 && H==1 && visit[0][0][0]==0) res=0;
		System.out.println(res);
	}
	
	
	private static void bfs(int r,int c,int cnt) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c,cnt});
		
		while(!queue.isEmpty()) {
			int[] a = queue.poll();
			int x = a[0];
			int y = a[1];
			int idx = a[2];
			
			if(idx<K) {					// ¸»Å½»ö °¡´É
				for(int i=0;i<8;i++) {
					int nx = x + hx[i];
					int ny = y + hy[i];
					
					if(nx<0 || nx>=H || ny<0 || ny>=W || arr[nx][ny]==1) continue;
					if(visit[idx+1][nx][ny]!=0) continue;
					
					visit[idx+1][nx][ny] = visit[idx][x][y] + 1;
					idx++;
					queue.offer(new int[] {nx,ny,idx});
					idx--;
				}
			}							// »ç¹æÅ½»ö
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || nx>=H || ny<0 || ny>=W || arr[nx][ny]==1) continue;
				if(visit[idx][nx][ny]!=0) continue;
				
				visit[idx][nx][ny] = visit[idx][x][y] + 1;
				queue.offer(new int[] {nx,ny,idx});
			}
		}
	}
}
