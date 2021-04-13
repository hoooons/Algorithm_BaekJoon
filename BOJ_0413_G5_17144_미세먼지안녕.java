package Algo;

import java.util.Scanner;

public class BOJ_0413_G5_17144_미세먼지안녕 {
	
	static int x1,x2;
	static int R,C,T;
	static int[][] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();	// 세로
		C = sc.nextInt();	// 가로
		T = sc.nextInt();	// 시간
		arr = new int[R][C];
		
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==-1) {
					if(x1==0) {
						x1 = i;
						continue;
					}
					x2 = i;
				}
			}
		}
		
		for(int i=0;i<T;i++) {
			// 확산
			spread();
			// 공기청정기 작동
			air();
		}
		
		int res = 0;
		
		// 미세먼지의 총합 구하기
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]>0)
					res+=arr[i][j];
			}
		}
		System.out.println(res);
	}

	private static void spread() {
		int[][] tmp = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j] > 0) {		// 먼지가있다면
					int cnt = 0;
					for(int k=0;k<4;k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx<0 || nx>=R || ny<0 || ny>=C || arr[nx][ny]==-1) continue;
						
						tmp[nx][ny] += arr[i][j]/5;
						cnt++;
					}
					tmp[i][j] += arr[i][j] - (cnt*(arr[i][j]/5));
				}
			}
		}
		
		// 배열 복사
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++) {
				if(arr[i][j]==-1) continue;
				arr[i][j] = tmp[i][j];
			}
		}
	}
	
	private static void air() {
		
		int x=x1-1,y=0;
		int dir = 0;
		while(true) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx==x1 && ny==0) {
				arr[x][y] = 0;
				break;
			}
			
			if(nx<0 || nx>x1 || ny>=C) {
				dir++;
				continue;
			}
			arr[x][y] = arr[nx][ny];
			x = nx;
			y = ny;
		}
		
		x=x2+1; y=0;
		dir = 0;
		while(true) {
			int nx = x + dr[dir];
			int ny = y + dc[dir];
			
			if(nx==x2 && ny==0) {
				arr[x][y] = 0;
				break;
			}
			
			if(nx>=R || ny>=C || nx<x2) {
				dir++;
				continue;
			}
			arr[x][y] = arr[nx][ny];
			x = nx;
			y = ny;
		}
	}
}































