package Algo;

import java.util.Scanner;

public class BOJ_0222_B3_8320_���簢��������¹�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = 0;
		
		count+=N;
		
		int tmp = 2;
		while(true) {
			if(N>=tmp*tmp) {
				int temp = tmp*tmp;
				while(true) {
					if(N>=temp) {
						count++;
						temp+=tmp;
					}
					else 
						break;
				}
			}
			else
				break;
			
			tmp++;
		}
		System.out.println(count);
		
	}
}
