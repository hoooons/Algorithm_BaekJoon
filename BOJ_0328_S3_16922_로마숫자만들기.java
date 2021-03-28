package Algo;

import java.util.Scanner;

public class BOJ_0328_S3_16922_로마숫자만들기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[] visit = new boolean[1001];	
		// 만들수있는 최대크기
		// 1001 = 50*20+1;
		
		/*
		 *  i->1의 갯수
		 *  j->5의 갯수
		 *  k->10의 갯수
		 *  tmp->50의 갯수
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
