package Algo;

import java.util.Scanner;

public class BOJ_0323_S3_1463_1¸¸µé±â {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		
		int[] arr = new int[X+1];
		arr[1] = 0;
		if(X>1) {
			arr[2] = 1;
			if(X>2)
				arr[3] = 1;
		}
		
		for(int i=4;i<=X;i++) {
			if(i%2==0 && i%3==0) {
				arr[i]=Math.min(arr[i-1], Math.min(arr[i/2], arr[i/3]))+1;
			}
			else if(i%2==0) {
				arr[i]=Math.min(arr[i-1], arr[i/2]) + 1;
			}
			else if(i%3==0){
				arr[i]=Math.min(arr[i-1], arr[i/3])	+ 1;
			}
			else {
				arr[i]=arr[i-1]+1;
			}
		}
		System.out.println(arr[X]);
	}
}
