package Algo;

import java.util.Scanner;

public class A_0201_S4_1244_����ġ�Ѱ���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		//�迭�Է� �ޱ�
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sc.next());
		}
		int student = sc.nextInt();
		//����, ����ġ �Է¹ޱ�
		for (int i = 0; i < student; i++) {
			int sex = sc.nextInt();
			int pick = sc.nextInt();
			//���ڶ��
			if (sex == 1) {
				int j = 1;
				while (true) {					//pick�� ����� ����ġ �ٲ��ֱ�
					if (arr[pick * j - 1] == 0)
						arr[pick * j - 1] = 1;
					else if (arr[pick * j - 1] == 1)
						arr[pick * j - 1] = 0;
					j++;
					if (pick * j > N)
						break;
				}
			//���ڶ��
			} else if (sex == 2) {				
				for (int j = 1; j <= N; j++) {
					
					if (arr[pick - 1] == 1 && j == 1)
						arr[pick - 1] = 0;
					else if (arr[pick - 1] == 0 && j == 1)
						arr[pick - 1] = 1;
					
					if (pick - 1 - j >= 0 && pick - 1 + j < N && arr[pick - 1 - j] == arr[pick - 1 + j]) {
						if (arr[pick - 1 - j] == 0) {
							arr[pick - 1 - j] = 1;
							arr[pick - 1 + j] = 1;
						} else if (arr[pick - 1 - j] == 1) {
							arr[pick - 1 - j] = 0;
							arr[pick - 1 + j] = 0;
						}
					} else
						break;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i]);
			if((i+1)%20!=0)
				System.out.print(" ");
			else if((i + 1) % 20 == 0)
				System.out.print("\n");
		}
		sc.close();
	}
}
