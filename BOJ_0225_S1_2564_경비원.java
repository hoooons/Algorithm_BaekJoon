package Algo;

import java.util.Scanner;

public class BOJ_0225_S1_2564_°æºñ¿ø {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int width = sc.nextInt();
		int height = sc.nextInt();
		
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		int[][] boy = new int[1][2];
				
		for(int i=0;i<N+1;i++) {
			for(int j=0;j<2;j++) {
				if(i==N) {
					boy[0][0] = sc.nextInt();
					boy[0][1] = sc.nextInt();
					break;
				}
				arr[i][j] = sc.nextInt();
			}
		}
		
		int sum = 0;
		
		for(int i=0;i<N;i++) {
			int a=0,b=0;
			if(boy[0][0] == 1) {
				if(arr[i][0]==1) {
					sum+=Math.abs(boy[0][1]-arr[i][1]);
				}
				else if(arr[i][0]==2) {
					a = height + boy[0][1] + arr[i][1];
					b = height + (width-boy[0][1])+(width-arr[i][1]);
					sum+=Math.min(a, b);
				}
				else if(arr[i][0]==3) {
					sum+=boy[0][1]+arr[i][1];
				}
				else {
					sum+=(width-boy[0][1])+arr[i][1];
				}
			}
			else if(boy[0][0]==2){
				if(arr[i][0]==1) {
					a = height + boy[0][1] + arr[i][1];
					b = height + (width-boy[0][1])+(width-arr[i][1]);
					sum+=Math.min(a, b);
				}
				else if(arr[i][0]==2) {
					sum+=Math.abs(boy[0][1]-arr[i][1]);
				}
				else if(arr[i][0]==3) {
					sum+=boy[0][1]+(height-arr[i][1]);
				}
				else {
					sum+=(width-boy[0][1])+(height-arr[i][1]);
				}
			}
			else if(boy[0][0]==3) {
				if(arr[i][0]==1) {
					sum+=boy[0][1]+arr[i][1];
				}
				else if(arr[i][0]==2) {
					sum+=(height-boy[0][1])+arr[i][1];
				}
				else if(arr[i][0]==3) {
					sum+=Math.abs(boy[0][1]-arr[i][1]);
				}
				else {
					a = width + boy[0][1] + arr[0][1];
					b = width + (height-boy[0][1])+(height-arr[i][1]);
					sum+=Math.min(a, b);
				}
			}
			else if(boy[0][0]==4) {
				if(arr[i][0]==1) {
					sum+=boy[0][1]+(width-arr[i][1]);
				}
				else if(arr[i][0]==2) {
					sum+=(height-boy[0][1])+(width-arr[i][1]);
				}
				else if(arr[i][0]==3) {
					a = width + boy[0][1] + arr[0][1];
					b = width + (height-boy[0][1])+(height-arr[i][1]);
					sum+=Math.min(a, b);
				}
				else {
					sum+=Math.abs(boy[0][1]-arr[i][1]);
				}
			}
		}
		System.out.println(sum);
	}
}
