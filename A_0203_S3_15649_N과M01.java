package Algo;

import java.util.Arrays;
import java.util.Scanner;

public class A_0203_S3_15649_N��M01 {
	static int[] numbers;
	static boolean[] ans;
	static int num;
	static int pick;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();						// �� ����
		pick = sc.nextInt();					// ���� ���� ��
		
		numbers = new int[pick];				// ��°��̴� ���� ���� ��
		ans = new boolean[num+1];				// Ȯ�� ���δ� �� ���� ��
		
		per(0);									// cnt0���� ����
	}
	
	static void per(int cnt){
		if(cnt==pick) {							// cnt�� ���� ���� ���� ���ٸ�
			for(int n:numbers){					
				System.out.print(n + " ");		// �ش� �迭 ����ϰ� return
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=num;i++) {				
			if(ans[i]==true) {					// ���ڰ� ������̶�� continue
				continue;						// (�ߺ� ��� x)
			}
			numbers[cnt]=i;						
			ans[i]=true;
			
			per(cnt+1);				// number(cnt)�� �̾����� cnt+1�� �̱����� ȣ��
			
			ans[i]=false;			// �ʱ�ȭ
		}
	}
}
