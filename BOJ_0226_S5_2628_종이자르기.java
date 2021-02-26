package Algo;

import java.util.Arrays;
import java.util.Scanner;

// 가로 0 세로 1
public class BOJ_0226_S5_2628_종이자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int R = sc.nextInt();
		int N = sc.nextInt();
		
		int[] a1 = new int[R];
		int[] a2 = new int[C];
		
		int idx1 = 0, idx2 = 0;
		for(int i=0;i<N;i++) {
			int tmp = sc.nextInt();
			if(tmp == 0) {
				a1[idx1] = sc.nextInt();
				idx1++;
			}
			else {
				a2[idx2] = sc.nextInt();
				idx2++;
			}
		}
		a1[idx1] = R;
		idx1++;
		a2[idx2] = C;
		idx2++;
		int[] arr1 = new int[idx1+1];
		int[] arr2 = new int[idx2+1];
		
		for(int i=0;i<idx1;i++)
			arr1[i] = a1[i];
		for(int i=0;i<idx2;i++)
			arr2[i] = a2[i];
		
		arr1[idx1] = 0;
		arr2[idx2] = 0;
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int r = 0, c = 0;
		int tmp1 = 0, tmp2 = 0;
		for(int i=0;i<idx1;i++) {
			tmp1 = arr1[i+1] - arr1[i];
			if(tmp1>r) {
				r = tmp1;
			}
		}
		for(int i=0;i<idx2;i++) {
			tmp2 = arr2[i+1] - arr2[i];
			if(tmp2>c) {
				c = tmp2;
			}
		}
		
		if(idx1 == 1) r = R;
		if(idx2 == 1) c = C;
		
		int res = r*c;
		System.out.println(res);
	}
}