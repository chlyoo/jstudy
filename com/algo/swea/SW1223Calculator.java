package _0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1223Calculator {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= 10; testCase++) {
			br.readLine();
			String s  =  br.readLine().replace("*","");
			String[] arr= s.split("[+]");
			long result  = 0;
			long val = 1;
			for (int i = 0; i < arr.length; i++) {
				val = 1;
				for (int j = 0; j < arr[i].length(); j++) {
					val *= arr[i].charAt(j)-'0';
				}
				result+=val;
			}
			sb.append("#").append(testCase).append(" ").append(result).append('\n');
		}
		System.out.print(sb);

	}

}