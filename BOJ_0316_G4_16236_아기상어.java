package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_0316_G4_16236_�Ʊ��� {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int N,shark,eat,res,end;
	static int[][] map;
	// bfs Ȱ��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				map[i][j] = sc.nextInt();
		
		shark = 2;										// ����� ũ��
		eat = 0;										// �� ���� ����� ��
		res = 0;
		end = 0;
		outer : while(true) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==9) {					// ���   (��ġ : i,j)
						bfs(i,j);
						if(end==1) break outer;			// ���̰������� ����
						if(eat==shark) {
							shark++;
							eat = 0;
						}
					}
				}
			}
		}
		System.out.println(res);
	}	
	// bfs �ʺ�켱Ž��
	private static void bfs(int a,int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {a,b});
		boolean[][] visit = new boolean[N][N];
		visit[a][b] = true;
		int[][] count = new int[N][N];
		
		while(!queue.isEmpty()) {
			int[] qp = queue.poll();
			int r = qp[0];
			int c = qp[1];
			
			for(int i=0;i<4;i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || visit[nr][nc]==true || map[nr][nc]>shark) continue;
				
				visit[nr][nc] = true;
				queue.offer(new int[] {nr,nc});
				count[nr][nc] = count[r][c] + 1;		
			}
		}
		int min=Integer.MAX_VALUE;					// ���尡��� ����
		int x=0,y=0;								// ������ǥ
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]<shark && map[i][j]>0 && count[i][j]>0) {				// ���̶��
					if(min>=count[i][j]) {
						if(min==count[i][j]) {
							if(i>x) {
								continue;
							}
							else if(i==x) {
								if(j>y) {
									continue;
								}
								else if(j<y) {
									min = count[i][j];
									x=i;
									y=j;
								}
							}
							else if(i<x) {
								min = count[i][j];
								x=i;
								y=j;
							}
						}
						else{
							min = count[i][j];
							x=i;
							y=j;
						}
					}
				}
			}
		}
		if(min==Integer.MAX_VALUE) {
			end=1;
			return;
		}
		res+=count[x][y];
		eat++;
		map[a][b] = 0;
		map[x][y] = 9;
	}
}
