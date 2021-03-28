package Algo;

import java.util.Scanner;

public class BOJ_0328_S1_12026_BOJ거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		char[] str = sc.nextLine().toCharArray();
		int size = str.length;
		int[] arr = new int[size];
		boolean[] visit = new boolean[size];
		
		visit[0] = true;
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<i;j++) {
				if(str[i]=='B') {
					if(str[j]=='J' && visit[j]==true) {
						int tmp = (i-j) * (i-j);
						if(arr[i]==0) {
							arr[i] = tmp + arr[j];
							visit[i] = true;
						}
						else if(arr[i]!=0 && arr[i]>tmp + arr[j]) {
							arr[i] = tmp + arr[j];
						}
					}
				}
				else if(str[i]=='O') {
					if(str[j]=='B' && visit[j]==true) {
						int tmp = (i-j) * (i-j);
						if(arr[i]==0) {
							arr[i] = tmp + arr[j];
							visit[i] = true;
						}
						else if(arr[i]!=0 && arr[i]>tmp + arr[j]) {
							arr[i] = tmp + arr[j];
						}
					}
				}
				else if(str[i]=='J') {
					if(str[j]=='O' && visit[j]==true) {
						int tmp = (i-j) * (i-j);
						if(arr[i]==0) {
							arr[i] = tmp + arr[j];
							visit[i] = true;
						}
						else if(arr[i]!=0 && arr[i]>tmp + arr[j]) {
							arr[i] = tmp + arr[j];
						}
					}
				}
			}
		}
		if(arr[size-1]==0)
			System.out.println(-1);
		else {
			System.out.println(arr[size-1]);
		}
	}
}
