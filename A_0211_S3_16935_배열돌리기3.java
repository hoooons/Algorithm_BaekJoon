package Algo;

import java.util.Scanner;

public class A_0211_S3_16935_�迭������3 {
	static int[][] arr;
	static int N,M,R;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][M];
		
		for(int i=0;i<N;i++)					//�迭 �Է¹ޱ�
			for(int j=0;j<M;j++)
				arr[i][j]=sc.nextInt();
		
		for(int t=0;t<R;t++) {					//���� �� ��ŭ �ݺ�
			int ch = sc.nextInt();
			if(ch==1) {							//���Ϲ���
				for(int i=0;i<N/2;i++)
					for(int j=0;j<M;j++) 
						swap(i,j,N-i-1,j);
			}
			else if(ch==2) {					//�¿����
				for(int i=0;i<N;i++) 
					for(int j=0;j<M/2;j++) 
						swap(i,j,i,M-j-1);
			}
			else if(ch==3) {					//������ 90��
				swap();
				int[][] brr = new int[N][M];
				for(int i=0;i<N;i++)
					for(int j=0;j<M;j++) {
						brr[i][j]=arr[M-j-1][i];
					}
				arr = brr;
			}
			else if(ch==4) {					//���� 90��
				swap();
				int[][] brr = new int[N][M];
				for(int i=0;i<N;i++)
					for(int j=0;j<M;j++) {
						brr[i][j] = arr[j][N-i-1];
					}
				arr=brr;
			}
			else if(ch==5) {					//�׷��̵�
					for(int i=0;i<N/2;i++) {
						for(int j=0;j<M/2;j++) {
							swap(i,j,i,j+M/2);
							swap(i,j,i+N/2,j+M/2);
							swap(i,j,i+N/2,j);
						}
					}
			}
			else if(ch==6) {					//�׷��̵�
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
	static void swap(int x,int y,int nx, int ny) {		// �迭 �ٲ��ִ� �Լ�
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
