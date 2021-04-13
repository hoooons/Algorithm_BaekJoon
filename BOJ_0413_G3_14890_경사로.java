package Algo;

import java.util.Scanner;

public class BOJ_0413_G3_14890_���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			int N = sc.nextInt();				// �迭ũ��
			int X = sc.nextInt();				// Ȱ�ַ� ����
			int[][] arr = new int[N][N];		// �迭
			int res = 0;						// �����
			
			for(int i=0;i<N;i++)				// �Է¹ޱ�
				for(int j=0;j<N;j++)
					arr[i][j] = sc.nextInt();	

			for(int i=0;i<N;i++) {				// ����Ȯ��
				int tmp = arr[i][0];			// ó����
				int cnt = 0;					// �Ʒ��ΰ��� ����
				int idx = 1;					// ���ΰ��� ����
				for(int j=1;j<N;j++) {
					if(Math.abs(tmp-arr[i][j])>=2) break;	// 2ĭ �̻����̳��� break
					if(arr[i][j]==tmp && cnt!=0) break;		
					if(arr[i][j]==tmp) {
						idx++;
						if(j==N-1) res++;
						continue;
					}
					// ��ĭ ���ΰ����
					if(idx>=X && arr[i][j]-1==tmp) {
						tmp = arr[i][j];
						idx = 1;
						cnt = 0;
						if(j==N-1) res++;
						continue;
					}
					if(idx<X && arr[i][j]-1==tmp) break;
					
					// ��ĭ �Ʒ��ΰ����
					cnt++;
					if(cnt==X) {
						tmp = arr[i][j];
						cnt = 0;
						idx = 0;
					}
					if(j==N-1 && cnt==0) res++;
				}	
			}
			for(int j=0;j<N;j++) {				// ����Ȯ��
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
