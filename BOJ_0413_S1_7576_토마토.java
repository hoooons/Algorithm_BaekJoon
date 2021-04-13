package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_0413_S1_7576_≈‰∏∂≈‰ {
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int M,N,cnt=0,check=0;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		outer : for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0) {
					cnt = -1;
					break outer;
				}
			}
		}
		if(check==0) cnt = 0;
		System.out.println(cnt);
	}
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1) {
					queue.add(new int[] {i,j});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || arr[nx][ny]!=0) continue;
			
				arr[nx][ny] = arr[x][y] + 1;
				if(arr[nx][ny]>cnt) cnt = arr[nx][ny];
				queue.add(new int[] {nx,ny});
				check = 1;
			}
		}
		cnt--;
	}
}
