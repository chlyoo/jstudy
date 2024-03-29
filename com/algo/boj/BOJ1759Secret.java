package _0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759Secret {
	private static int L;
	private static int C;
	private static String vowel = "aeiou";
	private static char[] map;
	private static char[] chars;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			map[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(map);
		chars = new char[L];
		comb(0,0,0);
	}
	//count c== 자음 countv == 모음 
	private static void comb(int start, int countc, int countv) {
		if(countc+countv == L) {
			if(countc >=2 && countv >=1) {
				for (int i = 0; i < chars.length; i++) {
					System.out.print(chars[i]);
				}
				System.out.println();
				return;
			}
			return;
		}
		for (int i = start; i < C; i++) {
			chars[countc+countv]=map[i];
			if(vowel.contains(Character.toString(map[i]))){
				comb(i+1, countc, countv+1);
			}else {
				comb(i+1, countc+1, countv);
			}
		}
	}
}
