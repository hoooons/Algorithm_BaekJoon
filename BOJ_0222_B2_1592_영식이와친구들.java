package Algo;

import java.util.Scanner;

public class BOJ_0222_B2_1592_영식이와친구들 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int count = 0;
		int[] arr = new int[N];
		arr[0] = 1;
		int cnt = 0;
		while(true) {
			if(arr[cnt]%2==1) {
				if(cnt+L<N) {
					cnt+=L;
				}
				else {
					cnt = cnt+L-N;
				}
				arr[cnt]++;
				count++;
			}
			else if(arr[cnt]%2==0) {
				if(cnt-L>=0) {
					cnt-=L;
				}
				else {
					cnt = cnt-L+N;
				}
				arr[cnt]++;
				count++;
			}
			
			if(arr[cnt]==M)
				break;
		}
		System.out.println(count);
	}
}
