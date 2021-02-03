package Algo;

import java.util.Scanner;

public class A_0203_S3_15652_N°úM04 {

	static int arr[];
	static int N;
	static int pick;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		pick = sc.nextInt();
		arr = new int[pick];

		per(0,1);
	}

	static void per(int cnt,int start) {
		if (cnt == pick) {
			for (int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= N; i++) {

			arr[cnt] = i;
			per(cnt + 1,i);

		}

	}
}
