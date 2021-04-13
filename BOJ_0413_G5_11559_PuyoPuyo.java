package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_0413_G5_11559_PuyoPuyo {
	 
	static int N=12,M=6,res;
	static int[][] arr;
	static boolean[][] ans;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[N][M];
		res = 0;
		
		for(int i=0;i<N;i++) {
			String s = sc.next();
			for(int j=0;j<M;j++) {
				char tmp = s.charAt(j);
				if(tmp=='.') arr[i][j]=0;
				else if(tmp=='R') arr[i][j]=1;
				else if(tmp=='G') arr[i][j]=2;
				else if(tmp=='B') arr[i][j]=3;
				else if(tmp=='P') arr[i][j]=4;
				else if(tmp=='Y') arr[i][j]=5;
			}
		}
		
		outer : while(true) {
			ans = new boolean[N][M];
			int check = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]!=0 && !ans[i][j]) {
						if(bfs(i,j)>=4) {		// ������ check�� ����
							check = 1;
						}
					}
				}
				if(i==N-1 && check==1) {		// �ѹ��̶� �����ٸ�
					// �����
					push();
					res++;
				}
				if(i==N-1 && check==0) break outer;		// �������ٸ� ����
			}
		}
		System.out.println(res);
	}
	private static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r,c});
		boolean[][] visit = new boolean[N][M];
		visit[r][c] = true;
		ans[r][c] = true;
		int cnt=1;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M 
						|| arr[r][c]!=arr[nx][ny] || ans[nx][ny]) continue;
				
				queue.add(new int[] {nx,ny});
				cnt++;
				ans[nx][ny] = true;
				visit[nx][ny] = true;
			}
		}
		// 4�� �̻��̸� ����
		if(cnt>=4) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visit[i][j]==true) {
						arr[i][j] = 0;
					}
				}
			}
		}
		return cnt;
	}
	
	private static void push() {
		for(int j=0;j<M;j++) {
			int idx = N-1;
			for(int i=N-1;i>=0;i--) {
				if(arr[i][j]!=0) {
					int tmp = arr[i][j];
					arr[i][j] = 0;
					arr[idx--][j] = tmp;
				}
			}
		}
	}
}



















