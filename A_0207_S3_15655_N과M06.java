package Algo;

import java.util.Arrays;
import java.util.Scanner;

public class A_0207_S3_15655_N°úM06 {

	
	static int[] arr;
	static int[] num;
	static int N;
	static int pick;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		pick = sc.nextInt();
		
		num = new int[N];
		arr = new int[pick]; 

		for(int i=0;i<N;i++) {
			num[i]=sc.nextInt();
		}
		
		com(0,0);

	}
	
	private static void com(int cnt,int start) {
		if(cnt==pick) {
			for(int i=0;i<pick;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<N;i++) {
			Arrays.sort(num);
			arr[cnt]=num[i];
			com(cnt+1,i+1);
		}
	}
}
