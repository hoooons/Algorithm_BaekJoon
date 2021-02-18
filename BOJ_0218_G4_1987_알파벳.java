package Algo;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_0218_G4_1987_알파벳 {
	
	//dfs 로 찾으면서 뺵트래킹으로 boolean이용한 차단
	//bfs 로 완전탐색 ?
	
	static Stack<Character> stack;
	static int[] dx = {1,0,0,-1};
	static int[] dy = {0,1,-1,0};
	static int R,C,res=1,count=1;
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		stack = new Stack<>();
		R = Integer.parseInt(sc.next());
		C = Integer.parseInt(sc.next());
		
		arr = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String s = sc.next();
			for(int j=0;j<C;j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		find(0,0);
		System.out.println(res);
	}
	
	private static void find(int r,int c) {
		stack.add(arr[r][c]);
		if(stack.size()!=count) {
			while(count!=stack.size())
				stack.pop();
		}
		outer : for(int k=0;k<4;k++) {
			if(stack.size()!=count) {
				while(count!=stack.size())
					stack.pop();
			}
			int nx = r + dx[k];
			int ny = c + dy[k];
			
			if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
			
			if(k==3 && stack.contains(arr[nx][ny])) {
				count--;
				return;
			}
			else if(k!=3 && stack.contains(arr[nx][ny]))
				continue outer;
			
			count++;
			res = count>res ? count : res;
			find(nx,ny);
		}
		count--;
	}
}
