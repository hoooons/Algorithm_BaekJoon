package Algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_0225_B2_2605_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int N = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			int num = sc.nextInt();
			
			if(num==0)
				list.add(i, i+1);
			else 
				list.add(i-num,i+1);
		}
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+" ");
	}
}
