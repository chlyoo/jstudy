package _0205;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW3499shuffle {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for (int testCase = 1; testCase <= TC; testCase++) {
			sb.append("#").append(testCase).append(" ");
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			for (int i = 0, index=0; index < N; i++) {
				sb.append(s[i]).append(" ");
				index++;
				if(index>=N) break;
				sb.append(s[i+(int)Math.round(N/2.0)]).append(" ");
				index++;
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
