package Algo;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_0218_G4_1987_¾ËÆÄºª1 {
	
	static int[] dx = {1,0,0,-1};
	static int[] dy = {0,1,-1,0};
	static int R,C,res=0;
	static char[][] arr;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = Integer.parseInt(sc.next());
		C = Integer.parseInt(sc.next());
		
		arr = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String s = sc.next();
			for(int j=0;j<C;j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		visit = new boolean[26];
		find(0,0,1);
		System.out.println(res);
	}
	
	private static void find(int r,int c,int cnt) {
		visit[arr[r][c]-'A']=true;
		res = res>cnt ? res : cnt;
		
		for(int k=0;k<4;k++) {
			int nx = r + dx[k];
			int ny = c + dy[k];
			
			if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
			
			if(visit[arr[nx][ny]-'A']==true) continue;
			
			find(nx,ny,cnt+1);
		}
		visit[arr[r][c]-'A']=false;
	}
}
