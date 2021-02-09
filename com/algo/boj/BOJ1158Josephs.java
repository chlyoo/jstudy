package com.algo.boj;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ1158Josephs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder("<");
		int N = sc.nextInt();
		int k = sc.nextInt();
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		int index=0;
		while(!q.isEmpty()) {//큐가 빌때까지
			index++;
			int save = q.poll();
			if(index%k == 0) {//다시 넣지 않고 출력에 저장
				sb.append(save).append(", ");
			}else {//차례가 아니면
			q.offer(save);
			}
		}
		sb.setLength(sb.length()-2);//마지막 공백과 컴마 제거
		sb.append(">");
		System.out.println(sb);
	}

}
