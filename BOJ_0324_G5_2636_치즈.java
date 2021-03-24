package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_0324_G5_2636_치즈 {
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int N,M,tmp;
	static int[][] arr;
	static boolean[][] ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		ans = new boolean[N][M];
		
		for(int i=0;i<N;i++) 
			for(int j=0;j<M;j++) 
				arr[i][j] = sc.nextInt();
		
		int time = 0,res=0;
		while(true) {
			tmp = 0;
			bfs(arr);
			wall(arr);
			melt(arr);
			if(tmp == 0) break;
			time++;
			res = tmp;
		}
		System.out.println(time);
		System.out.println(res);
	}
	private static void bfs(int[][] arr) {			// 테두리속 모두 true로 만들기 (치즈x포함)
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0,0});
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				ans[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] a = queue.poll();
			int x = a[0];
			int y = a[1];
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || ans[nx][ny]==false) continue;
				if(arr[nx][ny]==0) {
					ans[nx][ny] = false;
					queue.offer(new int[] {nx,ny});
				}
			}
		}
	}
	private static void wall(int[][] arr) {			// 테두리 찾기
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1) {
					for(int k=0;k<4;k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
						if(ans[nx][ny]==false) {
							arr[i][j] = 2;
							break;
						}
					}
				}
			}
		}
	}
	private static void melt(int[][] arr) {			// 1시간지나서 테두리녹음
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==2) {
					arr[i][j] = 0;
					tmp++;
				}
			}
		}
	}
}
