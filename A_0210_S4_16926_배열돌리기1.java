package Algo;

import java.util.Scanner;

public class A_0210_S4_16926_배열돌리기1 {
	
		static int[][] arr;
		static int N,M,R;
		static int[] dx= {1,0,-1,0};
		static int[] dy= {0,1,0,-1};
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			arr = new int[N][M];
			int idx = Math.min(N, M) / 2;
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < M; j++) 
					arr[i][j] = sc.nextInt();
			
			for(int t=0;t<R;t++) {
				int r= 0, c=0, ct = 0;
				
				while(true) {
					int start = arr[ct][ct];
					for(int i=0;i<4;i++) {
						while(true) {
							int nr = r+dx[i];
							int nc = c+dy[i];
							if (nr < ct|| nr >= N - ct || nc < ct || nc >= M - ct)
								break;
							
							swap(ct,ct,r,c);
							r=nr;
							c=nc;
						}
					}
//					arr[ct+1][ct]=start;
					ct++;
					if(ct==idx)
						break;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
		private static void swap(int a1, int b1, int a2, int b2) {
			int tmp = arr[a1][b1];
			arr[a1][b1] = arr[a2][b2];
			arr[a2][b2] = tmp;
	}	
}

