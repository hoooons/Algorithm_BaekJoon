package Algo;

import java.util.Scanner;

// 분할 정복
public class BOJ_0217_S1_1992_쿼드트리 {

	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++)
				arr[i][j] = s.charAt(j);
		}
		find(0,0,n);
		System.out.println(sb);
	}

	private static void find(int r,int c,int N) {
		int half = N / 2;
		outer : for(int i=r;i<r+N;i++) {
			for(int j=c;j<c+N;j++) {
				if(arr[r][c]!=arr[i][j])
					break outer;
			}
			if(i==N-1) {
				sb.append(arr[r][c]-'0');
				return;
			}
		}
		sb.append("(");
		if (N == 2) {
			sb.append(arr[r][c]-'0').append(arr[r][c+1]-'0').append(arr[r+1][c]-'0').append(arr[r+1][c+1]-'0').append(")");
			return;
		}
		
		search(r,c,half);
		c+=half;
		search(r,c,half);
		c-=half;
		r+=half;
		search(r,c,half);
		c+=half;			
		search(r,c,half);
		sb.append(")");
	}
	
	private static void search(int r,int c,int half) {
		for(int i=0;i<half;i++) {
			for(int j=0;j<half;j++) {
				if(arr[r][c]!=arr[r+i][c+j]) {
					find(r,c,half);
					return;
				}
			}
			if(i==half-1) {
				sb.append(arr[r][c]-'0');
			}
		}
	}
}
