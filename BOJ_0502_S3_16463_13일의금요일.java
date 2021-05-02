package Algo;

import java.util.Scanner;

public class BOJ_0502_S3_16463_13���Ǳݿ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] check = {1, 2, 3, 4, 5, 6, 7}; // ��ȭ���������
		long day = 13;
		
		for(int i=2019;i<=N;i++) {
			if((i%4==0 && i%100!=0) || i%400==0) {	// ����
				month[1] = 29;						// 2�� ����
			}else {
				month[1] = 28;
			}
			
			for(int j=0;j<12;j++) {
				if(check[(int) (day%7)]==5) {
					cnt++;
				}
				day+=month[j];
			}
		}
		System.out.println(cnt);
	}
}
