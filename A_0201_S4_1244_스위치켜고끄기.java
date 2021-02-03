package Algo;

import java.util.Scanner;

public class A_0201_S4_1244_스위치켜고끄기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		//배열입력 받기
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sc.next());
		}
		int student = sc.nextInt();
		//성별, 스위치 입력받기
		for (int i = 0; i < student; i++) {
			int sex = sc.nextInt();
			int pick = sc.nextInt();
			//남자라면
			if (sex == 1) {
				int j = 1;
				while (true) {					//pick의 배수인 스위치 바꿔주기
					if (arr[pick * j - 1] == 0)
						arr[pick * j - 1] = 1;
					else if (arr[pick * j - 1] == 1)
						arr[pick * j - 1] = 0;
					j++;
					if (pick * j > N)
						break;
				}
			//여자라면
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
