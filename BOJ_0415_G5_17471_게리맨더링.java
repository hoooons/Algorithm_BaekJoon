package Algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_0415_G5_17471_�Ը��Ǵ��� {
	
	static int N,res;
	static int[] people;
	static int[][] arr;
	static boolean[] ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		people = new int[N+1];
		arr = new int[N+1][N+1];
		ans = new boolean[N+1];
		
		for(int i=1;i<N+1;i++)				// �α��� ���
			people[i] = sc.nextInt();
		
		for(int i=1;i<N+1;i++) {
			int tmp = sc.nextInt();
			for(int j=0;j<tmp;j++) {
				int conn = sc.nextInt();
				arr[i][conn] = 1;
			}
		}
		res = Integer.MAX_VALUE;
		sub(1);
		if(res==Integer.MAX_VALUE) res = -1;
		System.out.println(res);
	}
	// �κ������� �̿��Ͽ� ����Ž��
	private static void sub(int cnt) {
		if(cnt==N+1) {
			List<Integer> list1 = new ArrayList<>();		// 1���ű�
			List<Integer> list2 = new ArrayList<>();		// 2���ű�
			int tmp=0;
			int sum1 = 0, sum2 = 0;
			for(int i=1;i<N+1;i++) {		// �� ���ű� �α��� ��� AND ���ű�����Ʈ�� �߰�
				if(ans[i]==true) {
					sum1+=people[i];
					list1.add(i);
					tmp++;
				}else {
					sum2+=people[i];
					list2.add(i);
				}
			}
			if(tmp==0 || tmp==N) return;	// �ϳ��� ������ �����ؾ���
			
			// BFS�� ������ִ��� Ȯ��
			if(!bfs(list1)) return;
			if(!bfs(list2)) return;
			
			int sum = Math.abs(sum1-sum2);
			if(res>sum) res = sum;
			
			return;
		}
		ans[cnt] = true;
		sub(cnt+1);
		ans[cnt] = false;
		sub(cnt+1);
	}
	// ���� ������ִ��� Ȯ��
	private static boolean bfs(List<Integer> list) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(list.get(0));
		boolean[] visit = new boolean[list.size()+1];
		visit[1] = true;
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			for(int i=0;i<list.size();i++) {
				if(a==list.get(i) || visit[i+1]) continue;
				if(arr[a][list.get(i)]==1) {
					queue.add(list.get(i));
					visit[i+1] = true;
				}
			}
		}
		for(int i=1;i<list.size()+1;i++) 
			if(visit[i]==false) return false;
		
		return true;
	}
}
