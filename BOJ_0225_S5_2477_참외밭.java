package Algo;

import java.util.Scanner;

public class BOJ_0225_S5_2477_Âü¿Ü¹ç {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();

		int[][] arr = new int[6][2];
		int width = 0, height = 0;

		for (int i = 0; i < 6; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		for (int i = 0; i < 6; i++) {
			if (arr[i][0] == 1 || arr[i][0] == 2) {
				if (arr[i][1] > width) {
					width = arr[i][1];
				}
			} else if (arr[i][0] == 3 || arr[i][0] == 4) {
				if (arr[i][1] > height) {
					height = arr[i][1];
				}
			}
		}
		int wid = 0, hei = 0;

		for (int i = 0; i < 6; i++) {
			if(arr[i][0] == 1 || arr[i][0] == 2) {
				if (arr[(i + 5) % 6][1] + arr[(i + 1) % 6][1] == height) {
					hei = arr[i][1];
				}
			}else if(arr[i][0] == 3 || arr[i][0] == 4) {
				if (arr[(i + 5) % 6][1] + arr[(i + 1) % 6][1] == width) {
					wid = arr[i][1];
				}
			}
		}
		System.out.println( (width*height - wid * hei) * K );
	}
}
