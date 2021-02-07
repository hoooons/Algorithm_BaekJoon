package Algo;

import java.util.Arrays;
import java.util.Scanner;

public class A_0207_S3_15656_N°úM07 {
	
	static int[] num;
	static int[] arr;
	static int N;
	static int pick;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		pick = sc.nextInt();
		arr = new int[pick];
		num = new int[N];
		
		for(int i=0;i<N;i++) {
			num[i]=sc.nextInt();
		}
		
		per(0);
		System.out.println(sb);
	}
	static StringBuilder sb = new StringBuilder();
	private static void per(int cnt) {
		if(cnt==pick) {
			for(int i=0;i<pick;i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			Arrays.sort(num);
			arr[cnt]=num[i];
			per(cnt+1);
		}
	}
}
