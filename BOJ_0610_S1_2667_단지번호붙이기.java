package Algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_0610_S1_2667_단지번호붙이기 {
	
	static int N,res;
	static List<Integer> list;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.next());
		res = 0;
		list = new ArrayList<>();
		arr = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String str = sc.next();
			for(int j=0;j<N;j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++){
				if(arr[i][j]==1 && visit[i][j]==false) {
					int tmp = bfs(i,j);
					list.add(tmp);
				}
			}
		}
		Collections.sort(list);
		System.out.println(res);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	private static int bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		int cnt = 1;
		visit[i][j] = true;
		queue.add(new int[] {i,j});
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int k=0;k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				
				if(arr[nx][ny]==1 && visit[nx][ny]!=true) {
					queue.add(new int[] {nx,ny});
					cnt++;
					visit[nx][ny] = true;
				}
			}
		}
		res++;
		return cnt;
	}
}
