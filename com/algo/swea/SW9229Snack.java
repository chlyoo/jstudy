package _0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW9229Snack {
	static int N, L, map[];
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= TC; testCase++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]); //과자 개수
			L = Integer.parseInt(s[1]); //Limit
			isSelected = new boolean[N];
			s = br.readLine().split(" ");
			map = new int[N];
			for (int i = 0; i < N; i++) { //N개의 과자 무게를 배열에 집어넣는다.
				map[i] = Integer.parseInt(s[i]);
			}
			int val =pick(0,0,2);
			sb.append("#").append(testCase).append(" ").append(val).append('\n');
		}//endfor
		System.out.print(sb);
	}//end main

	//과자를 골라서 최대값을 반환 하는 함수
	private static int pick(int cnt, int weight, int hands) {
		if(hands<0) { //2개를 이미 집고 또 집으려고 하는 경우 
			return -1;
		}
		if(weight>L) { //무게를 초과하는 경우 -1 리턴
			return -1;
		}
		if(hands==0) { //2번 다집은 경우
			return weight;
		}
		if(cnt==N) { // 끝까지 다 탐색한 경우
			return -1;
		}
		//과자를 고르는 경우
		int h1 = pick(cnt+1 , weight, hands);
		//과자를 고르지 않는 경우
		int h2 = pick(cnt+1 , weight+map[cnt], hands-1);
		return Math.max(h1, h2); //최대 값 반환

	}
}//end class
