package Algo;

import java.util.Scanner;

// Combination 으로 풀기
public class BOJ_0317_S3_14889_스타트와링크 {
	
	static int N,P,res;
	static int[][] arr;
	static int[] pick;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][N];
		P = N/2;
		pick = new int[P];
		
		for(int i=0;i<N;i++) 
			for(int j=0;j<N;j++) 
				arr[i][j] = sc.nextInt();
		
		res = Integer.MAX_VALUE;
		com(0,0);
		System.out.println(res);
	}
	
	// Combination
	private static void com(int cnt, int start) {
		if(cnt==P) {
			
			int[] tmp = new int[P];
			boolean[] ans = new boolean[N];
			
			for(int i=0;i<P;i++) 
				ans[pick[i]]=true;
			
			int idx = 0;
			for(int i=0;i<N;i++) {		// team1에 속하지않은사람을 team2에 넣어줌
				if(ans[i]==false) {
					tmp[idx++] = i;
				}
			}
			
			int team1=0,team2=0;		
			for(int i=0;i<P-1;i++) {
				for(int j=i+1;j<P;j++) {
					team1 += arr[pick[i]][pick[j]] + arr[pick[j]][pick[i]];
					team2 += arr[tmp[i]][tmp[j]] + arr[tmp[j]][tmp[i]];
				}
			}
			if(Math.abs(team1-team2)<res)
				res = Math.abs(team1-team2);
			
			return;
		}
		for(int i=start;i<N;i++) {
			pick[cnt]=i;
			com(cnt+1,i+1);
		}
	}
}
