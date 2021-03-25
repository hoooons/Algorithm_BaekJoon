package Algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_0325_G4_14002_����������ϴºκм���4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] num = new int[N];
		int[][] LIS = new int[N][2];// [0]�� ���̰�, [1]�� ������ ��ġ��
		for(int i=0;i<N;i++)
			num[i] = sc.nextInt();
		
		int max = 0,idx=0;
		for(int i=0;i<N;i++) {
			LIS[i][0] = 1;
			for(int j=0;j<i;j++) {
				if(num[j]<num[i] && LIS[j][0]+1>LIS[i][0]) {
					LIS[i][0]=LIS[j][0]+1;
					LIS[i][1]=j;
				}
			}
			if(max<LIS[i][0]) {
				max = LIS[i][0];
				idx = i;				// �ִ밪�� ��ġ
			}
		}
		List<Integer> list = new LinkedList<>();	// ����Ʈ�� ����
		for(int i=max;i>0;i--) {
			list.add(num[idx]);
			idx = LIS[idx][1];
		}
		System.out.println(max);
		for(int i=list.size()-1;i>=0;i--) {
			System.out.print(list.get(i)+" ");
		}
	}
}
