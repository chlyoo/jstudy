package _0208;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW5215Hamburger {
	static int val, N, L;
	static boolean[] isSelected;
	static int[][] map;
	static String src ="";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(src.getBytes())));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][2];
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			val = combination(0, 0, 0);
			sb.append("#").append(testCase).append(" ").append(val).append('\n');
		}
		System.out.print(sb);
	}
	static int m=0;
	//cnt 번째의 재료를 고려해서 (조합에 넣을수도 안넣을 수도_) 
	//칼로리 체크후 맛점수 변경
	private static int combination(int cnt,int taste, int calorie) {
		if(calorie>L) {
			return 0;
		}
		if(calorie==L) {
			return taste;
		}
		if(cnt==N) {
			return taste;
		}
		//idx번째 재료를 사용하지 않는 경우
		int va = combination(cnt+1, taste, calorie);
		
		//idx번째 재료를 사용한 경우
		int vb = combination(cnt+1,taste+map[cnt][0],calorie+map[cnt][1]);
		
		return Math.max(va, vb);
	}

}
