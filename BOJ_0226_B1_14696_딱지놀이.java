package Algo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//별 동그라미 네모 세모   4 3 2 1
public class BOJ_0226_B1_14696_딱지놀이 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		
		for(int i = 0;i<N;i++) {
			A.clear();
			B.clear();
			
			int aa = sc.nextInt();
			for(int j=0;j<aa;j++)
				A.add(sc.nextInt());
			int bb = sc.nextInt();
			for(int j=0;j<bb;j++)
				B.add(sc.nextInt());
			
			int a1 = 0, b1 = 0, c1 = 0, d1 =0;
			int a2 = 0, b2 = 0, c2 = 0, d2 =0;
			
			for(int j=0;j<aa;j++) {
				if(A.get(j)==4)
					a1++;
				if(A.get(j)==3)
					b1++;
				if(A.get(j)==2)
					c1++;
				if(A.get(j)==1)
					d1++;
			}
			for(int j=0;j<bb;j++) {
				if(B.get(j)==4)
					a2++;
				if(B.get(j)==3)
					b2++;
				if(B.get(j)==2)
					c2++;
				if(B.get(j)==1)
					d2++;
			}
			
			if(a1>a2)
				System.out.println("A");
			else if(a1<a2)
				System.out.println("B");
			else {
				if(b1>b2)
					System.out.println("A");
				else if(b1<b2)
					System.out.println("B");
				else {
					if(c1>c2)
						System.out.println("A");
					else if(c1<c2)
						System.out.println("B");
					else {
						if(d1>d2)
							System.out.println("A");
						else if(d1<d2)
							System.out.println("B");
						else {
							System.out.println("D");
						}
					}
				}
			}
		}
	}
}
