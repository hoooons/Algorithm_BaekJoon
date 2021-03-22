package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_0322_G1_1786_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tLen = text.length, pLen = pattern.length;	// text, pattern 문자열 길이
		int[] fail = new int[pLen];						// 실패함수
		
		// 실패함수 만들기
		for(int i=1,j=0;i<pLen;i++) {
			while(j>0 && pattern[i] != pattern[j]) {
				j = fail[j-1];
			}
			if(pattern[i]==pattern[j])	// 같으면 넣어줌
				fail[i] = ++j;
		}
		
		int count = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0,j=0;i<tLen;i++) {
			while(j>0 && text[i]!=pattern[j]) {
				j = fail[j-1];
			}
			if(text[i]==pattern[j]) {
				if(j==pLen-1) {
					count++;
					list.add((i+1)-pLen+1);
					j=fail[j];
				}
				else {
					j++;
				}
			}
		}
		System.out.println(count);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
