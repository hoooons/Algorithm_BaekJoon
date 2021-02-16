package Algo;

import java.util.Scanner;

public class BOJ_0216_S1_1074_Z {
	
	static int N,R,C,size;
	static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		size = 1;
		for(int i=0;i<N;i++) size *= 2;
		
		find(N);
		System.out.println(res);
	}
	private static void find(int n) {
		int newSize = 1;
		for(int i=0;i<n;i++) newSize*=2;

		//최종 2*2 배열
		if(n==1) {
			if(R==0 && C==1) res+=1;
			else if(R==1 && C==0) res+=2;
			else if(R==1 && C==1) res+=3;
			return;
		}
		int h = newSize / 2;
		
		//1사분면에선 Pass, 나머지 사분면에선 첫값만큼 더해줌
		if(h<=C && R<h) res+=h*h;
		else if(h<=R && C<h) res+=h*h*2;
		else if(h<=R && h<=C) res+=h*h*3;
		
		R%=h;
		C%=h;
		
		find(n-1);
	}
}
