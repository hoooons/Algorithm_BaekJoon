package Algo;

import java.util.Arrays;
import java.util.Scanner;

public class A_0203_S3_15654_N°úM05 {
	
	static int arr[];
	static int num[];
	static int N;
	static int pick;
	static boolean ans[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		pick=sc.nextInt();
		
		arr = new int[pick];
		num = new int[N];
		ans = new boolean[N+1];
		
		for(int i=0;i<N;i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		per(0);
		System.out.println(sb);
	}
	static StringBuilder sb = new StringBuilder();
	static void per(int cnt) {
		if(cnt==pick) {
			for(int a: arr) {
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(ans[i]==true)
				continue;
			
			arr[cnt]=num[i-1];
			ans[i]=true;
			per(cnt+1);
			ans[i]=false;
		}	
	}
}
