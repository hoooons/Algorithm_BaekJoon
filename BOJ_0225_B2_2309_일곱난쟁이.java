package Algo;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_0225_B2_2309_ÀÏ°ö³­ÀïÀÌ {
	
	static int[] arr,num,res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = new int[9];
		num = new int[7];
		res = new int[7];
		for(int i=0;i<9;i++)
			arr[i] = sc.nextInt();
		
		com(0,0);
		
		Arrays.sort(res);
		for(int i=0;i<7;i++)
			System.out.println(res[i]);
	}
	
	private static void com(int cnt,int start) {
		if(cnt==7) {
			int sum = 0;
			for(int i=0;i<7;i++) {
				sum+=arr[num[i]];
			}
			if(sum==100) {
				for(int i=0;i<7;i++) {
					res[i] = arr[num[i]];
				}
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			num[cnt]=i;
			com(cnt+1,i+1);
		}
	}
}
