package Algo;

import java.util.LinkedList;

import java.util.Queue;
import java.util.Scanner;

public class A_0209_S5_1158_요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) queue.offer(i);
		System.out.print("<");
		int count = 0;
		outer : while(true) {
			for(int i=0;i<K;i++) {
				if(i==K-1) {
					if(count==N-1) {
						System.out.print(queue.poll());
						break outer;
					}
					else {
						System.out.print(queue.poll()+", ");
						count++;
					}
				}
				else {
					queue.offer(queue.poll());
				}
			}
		}
		System.out.println(">");
	}
}

