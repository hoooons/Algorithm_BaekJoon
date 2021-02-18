package Algo;

import java.util.Scanner;

public class BOJ_0218_G2_3109_»§Áý {
	static int R,C,res=0,check=0;
	static char[][] arr;
	static boolean[][] ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = Integer.parseInt(sc.next());
		C = Integer.parseInt(sc.next());
		arr = new char[R][C];
		ans = new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			String s = sc.next();
			for(int j=0;j<C;j++) {
				arr[i][j] = s.charAt(j);
				if(s.charAt(j)=='x') ans[i][j] = true;
			}
		}
		for(int i=0;i<R;i++) {
			check=0;
			pipe(0,i);
		}
		System.out.println(res);
	}
	private static void pipe(int start,int col) {
		
		if(start==C-1) {
			res++;
			check = 1;
			return;
		}
		for(int i=col-1;i<=col+1;i++) {
			if(check==1) return;

			if(i>=0 && i<R && ans[i][start+1]==false) {
				ans[i][start+1]=true;
				pipe(start+1,i);
			}
		}
	}
}

