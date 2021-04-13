package Algo;

import java.util.Scanner;

public class BOJ_0413_G3_14890_경사로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			int N = sc.nextInt();				// 배열크기
			int X = sc.nextInt();				// 활주로 길이
			int[][] arr = new int[N][N];		// 배열
			int res = 0;						// 결과값
			
			for(int i=0;i<N;i++)				// 입력받기
				for(int j=0;j<N;j++)
					arr[i][j] = sc.nextInt();	

			for(int i=0;i<N;i++) {				// 가로확인
				int tmp = arr[i][0];			// 처음값
				int cnt = 0;					// 아래로가는 경사로
				int idx = 1;					// 위로가는 경사로
				for(int j=1;j<N;j++) {
					if(Math.abs(tmp-arr[i][j])>=2) break;	// 2칸 이상차이나면 break
					if(arr[i][j]==tmp && cnt!=0) break;		
					if(arr[i][j]==tmp) {
						idx++;
						if(j==N-1) res++;
						continue;
					}
					// 한칸 위로갈경우
					if(idx>=X && arr[i][j]-1==tmp) {
						tmp = arr[i][j];
						idx = 1;
						cnt = 0;
						if(j==N-1) res++;
						continue;
					}
					if(idx<X && arr[i][j]-1==tmp) break;
					
					// 한칸 아래로갈경우
					cnt++;
					if(cnt==X) {
						tmp = arr[i][j];
						cnt = 0;
						idx = 0;
					}
					if(j==N-1 && cnt==0) res++;
				}	
			}
			for(int j=0;j<N;j++) {				// 세로확인
				int tmp = arr[0][j];		
				int cnt = 0;
				int idx = 1;
				for(int i=1;i<N;i++) {
					if(Math.abs(tmp-arr[i][j])>=2) break;
					if(arr[i][j]==tmp && cnt!=0) break;
					if(arr[i][j]==tmp) {
						idx++;
						if(i==N-1) res++;
						continue;
					}
					
					if(idx>=X && arr[i][j]-1==tmp) {
						tmp = arr[i][j];
						idx = 1;
						cnt = 0;
						if(i==N-1) res++;
						continue;
					}
					if(idx<X && arr[i][j]-1==tmp) break;
					
					cnt++;
					if(cnt==X) {
						tmp = arr[i][j];
						cnt = 0;
						idx = 0;
					}
					if(i==N-1 && cnt==0) res++;
				}
			}
			System.out.println(res);
		}
}
