package Algo;

import java.util.Scanner;

public class BOJ_0225_S5_10157_자리배정 {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();
		int find = sc.nextInt();
		int dir = 0;
		int[][] arr = new int[R][C];
		boolean[][] ans = new boolean[R][C];

		if (C * R < find) {
			System.out.println(0);
			return;
		}

		if (find == 1) {
			System.out.println(1+" "+1);
			return;
		}

		int r = 0, c = 0, count = 1;
		arr[r][c] = 1;
		ans[r][c] = true;

		for (int i = 0; i < R * C; i++) {
			int nr = r + dx[dir];
			int nc = c + dy[dir];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C || ans[nr][nc] == true) {
				dir++;
				if (dir == 4)
					dir = 0;
			}
			
			r += dx[dir];
			c += dy[dir];

			arr[r][c] = ++count;
			ans[r][c] = true;

			if (arr[r][c] == find) {
				System.out.println((r + 1) + " " + (c + 1));
				break;
			}
		}
	}
}
