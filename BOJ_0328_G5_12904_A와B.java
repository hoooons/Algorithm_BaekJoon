package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_0328_G5_12904_A¿ÍB {
	
	static String s,t;
	static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		s = sc.nextLine();
		t = sc.nextLine();
		
		bfs(t);
		System.out.println(res);
	}
	
	private static void bfs(String t) {
		Queue<String> queue = new LinkedList<>();
		queue.add(t);
		
		while(!queue.isEmpty()) {
			String str = queue.poll();
			
			if(str.length()<s.length()) break;
			if(str.equals(s)) {
				res = 1;
				break;
			}
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			
			if(str.charAt(str.length()-1)=='A') {
				sb.deleteCharAt(str.length()-1);
			}
			else if(str.charAt(str.length()-1)=='B') {
				sb.deleteCharAt(str.length()-1);
				sb.reverse();
			}
			queue.add(sb.toString());
		}
	}
}
