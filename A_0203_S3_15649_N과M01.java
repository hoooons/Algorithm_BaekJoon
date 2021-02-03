package Algo;

import java.util.Arrays;
import java.util.Scanner;

public class A_0203_S3_15649_N과M01 {
	static int[] numbers;
	static boolean[] ans;
	static int num;
	static int pick;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();						// 총 숫자
		pick = sc.nextInt();					// 고르는 숫자 수
		
		numbers = new int[pick];				// 출력값이니 고르는 숫자 수
		ans = new boolean[num+1];				// 확인 여부니 총 숫자 수
		
		per(0);									// cnt0부터 시작
	}
	
	static void per(int cnt){
		if(cnt==pick) {							// cnt가 고르는 숫자 수와 같다면
			for(int n:numbers){					
				System.out.print(n + " ");		// 해당 배열 출력하고 return
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=num;i++) {				
			if(ans[i]==true) {					// 숫자가 사용중이라면 continue
				continue;						// (중복 허용 x)
			}
			numbers[cnt]=i;						
			ans[i]=true;
			
			per(cnt+1);				// number(cnt)값 뽑았으니 cnt+1값 뽑기위해 호출
			
			ans[i]=false;			// 초기화
		}
	}
}
