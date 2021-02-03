package Algo;

import java.util.Scanner;

public class A_0203_S3_15651_N°úM03 {
	
	static int num;
	static int pick;
	static int[] numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		pick = sc.nextInt();
		numbers = new int[pick];
		per(0);
		System.out.println(sb.toString());
	}
	static StringBuilder sb = new StringBuilder();
	static void per(int cnt) {
		if(cnt==pick) {
			for(int n: numbers) {
				sb.append(n+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1;i<=num;i++) {
			numbers[cnt]=i;
			per(cnt+1);
		}
	}
}

/*
  import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main{
	
	static int num;
	static int pick;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		pick = sc.nextInt();
		numbers = new int[pick];
		per(0,bw);
		bw.close();
	}
	static void per(int cnt,BufferedWriter bw) throws IOException {
		if(cnt==pick) {
			for(int n: numbers) {
				bw.write(n+" ");
			}
			bw.write("\n");
			return;
		}
		for(int i=1;i<=num;i++) {
			numbers[cnt]=i;
			per(cnt+1,bw);
		}
	}
}
*/
