package Algo;

import java.util.Scanner;

public class A_0211_S3_16935_배열돌리기3 {
	static int[][] arr;
	static int N,M,R;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][M];
		
		for(int i=0;i<N;i++)					//배열 입력받기
			for(int j=0;j<M;j++)
				arr[i][j]=sc.nextInt();
		
		for(int t=0;t<R;t++) {					//연산 수 만큼 반복
			int ch = sc.nextInt();
			if(ch==1) {							//상하반전
				for(int i=0;i<N/2;i++)
					for(int j=0;j<M;j++) 
						swap(i,j,N-i-1,j);
			}
			else if(ch==2) {					//좌우반전
				for(int i=0;i<N;i++) 
					for(int j=0;j<M/2;j++) 
						swap(i,j,i,M-j-1);
			}
			else if(ch==3) {					//오른쪽 90도
				swap();
				int[][] brr = new int[N][M];
				for(int i=0;i<N;i++)
					for(int j=0;j<M;j++) {
						brr[i][j]=arr[M-j-1][i];
					}
				arr = brr;
			}
			else if(ch==4) {					//왼쪽 90도
				swap();
				int[][] brr = new int[N][M];
				for(int i=0;i<N;i++)
					for(int j=0;j<M;j++) {
						brr[i][j] = arr[j][N-i-1];
					}
				arr=brr;
			}
			else if(ch==5) {					//그룹이동
					for(int i=0;i<N/2;i++) {
						for(int j=0;j<M/2;j++) {
							swap(i,j,i,j+M/2);
							swap(i,j,i+N/2,j+M/2);
							swap(i,j,i+N/2,j);
						}
					}
			}
			else if(ch==6) {					//그룹이동
				for(int i=0;i<N/2;i++) {
					for(int j=0;j<M/2;j++) {
						swap(i,j,i+N/2,j);
						swap(i,j,i+N/2,j+M/2);
						swap(i,j,i,j+M/2);
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void swap(int x,int y,int nx, int ny) {		// 배열 바꿔주는 함수
		int tmp = arr[x][y];
		arr[x][y] = arr[nx][ny];
		arr[nx][ny] = tmp;
	}
	static void swap() {
		int tmp = N;
		N = M;
		M = tmp;
	}
}
