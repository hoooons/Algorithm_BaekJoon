package Algo;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_0222_S3_17413_단어뒤집기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		char[] arr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		
		outer : for(int i=0;i<arr.length;i++) {
			if(arr[i]=='<') {
				for(int j=i;j<arr.length;j++) {
					if(arr[j]=='>') {
						i=j;
						break;
					}
				}
			}
			else {
				for(int j=i;j<arr.length;j++) {
					if(j==arr.length-1) {
						stack.add(arr[j]);
						for(int k=i;k<=j;k++) {
							arr[k]=stack.pop();
						}
						break outer;
					}
					else if(arr[j]=='<') {
						for(int k=i;k<j;k++) {
							arr[k]=stack.pop();
						}
						i=j-1;
						break;
					}
					else if(arr[j]==' ') {
						for(int k=i;k<j;k++) {
							arr[k]=stack.pop();
						}
						i=j;
						break;
					}
					stack.add(arr[j]);
				}
			}
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]);
	}
}
