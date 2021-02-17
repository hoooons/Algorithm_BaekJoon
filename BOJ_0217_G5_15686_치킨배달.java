package Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_0217_G5_15686_치킨배달 {

	static int dx[] = {-1,1,0,0,-1,-1,1,1 };
	static int dy[] = { 0,0,-1,1,-1,1,-1,1};
	static int N, M, res = Integer.MAX_VALUE;
	static int[][] map;
	static int[] ans;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2)
					list.add(new int[] { i, j });
			}
		}
		ans = new int[M];
		com(0, 0);
		System.out.println(res);
	}

	private static void com(int cnt, int start) {
		if (cnt == M) {
			int sum = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==1) {
						int tmp=100 , tmp2;
						for(int k=0;k<M;k++) {
							tmp2 = Math.abs(list.get(ans[k])[0]-i) + Math.abs(list.get(ans[k])[1]-j);
							if(tmp2<tmp) tmp = tmp2;
						}
						sum+=tmp;
					}
				}
			}
			if(sum<res) res = sum;
			return;
		}
		for (int i = start; i < list.size(); i++) {
			ans[cnt] = i;
			com(cnt + 1, i + 1);
		}
	}
}
