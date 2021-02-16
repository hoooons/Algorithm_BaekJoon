package Algo;

import java.util.Scanner;

public class BOJ_0216_B1_2839_º≥≈¡πË¥ﬁ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = 0, cnt = 0;

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= N / 5; i++) {
			int tmp = N;
			tmp -= 5 * i;
			if (tmp % 3 == 0) {
				cnt += i;
				cnt += tmp / 3;

				if (cnt < min)
					min = cnt;
			}
			cnt = 0;
		}
		if(min==Integer.MAX_VALUE) res = -1;
		else res = min;

		System.out.println(res);
	}
}
