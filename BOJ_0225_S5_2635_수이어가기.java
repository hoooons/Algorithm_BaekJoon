package Algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_0225_S5_2635_수이어가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int res = 0;
		List<Integer> resList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			list.clear();
			list.add(N);
			list.add(i);
			int count = 2;
			int n = 0;
			while(true) {
				int tmp = list.get(n)-list.get(n+1);
				
				if(tmp<0) break;
				
				list.add(tmp);
				count++;
				n++;
			}
			if(count>res) {
				res = count;
				resList.clear();
				for(int j=0;j<list.size();j++)
					resList.add(list.get(j));
			}
		}
		System.out.println(res);
		for(int i=0;i<resList.size();i++)
			System.out.print(resList.get(i)+" ");
	}
}
