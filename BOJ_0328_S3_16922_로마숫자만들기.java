package Algo;

import java.util.Scanner;

public class BOJ_0328_S3_16922_�θ����ڸ���� {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[] visit = new boolean[1001];	
		// ������ִ� �ִ�ũ��
		// 1001 = 50*20+1;
		
		/*
		 *  i->1�� ����
		 *  j->5�� ����
		 *  k->10�� ����
		 *  tmp->50�� ����
		 */
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=N-i;j++) {
				for(int k=0;k<=N-i-j;k++) {
					int tmp = N-i-j-k;
					int num = i+5*j+10*k+50*tmp;
					visit[num]=true;
				}
			}
		}
		int res = 0;
		for(int i=0;i<1001;i++) {
			if(visit[i]) res++;
		}
		System.out.println(res);
	}
}
