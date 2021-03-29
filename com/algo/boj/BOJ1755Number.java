package com.algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1755Number {

	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));  //사용자 입력 받기 
		StringTokenizer st = new StringTokenizer(br.readLine()); //스트링 토크나이저에 한줄 입력 받기 
		int M = Integer.parseInt(st.nextToken()); //공백 기준 토크나이징 처음에 온 토큰은 시작 
		int N = Integer.parseInt(st.nextToken()); //그 다음 온 토큰은 마지막
		String[][] arr = new String[N-M+1][2];   //영어로 변환한 문자열과 원래 숫자를  담을 배열
		StringBuilder sb = new StringBuilder(); //임시 문자를 저장할 스트링 빌더 
		for (int i = M; i <= N; i++) { //M이상 N이하
			String temp = Integer.toString(i);  //정수값을 스트링으로 변환
			sb.setLength(0); //스트링 빌더 초기화 
			for (int j = 0; j < temp.length(); j++) {
				// 1 = one 2 two 3 three 4 four 5 five 6 six 7 seven 8 eight 9 nine 10 one zero
				switch (temp.charAt(j)) { // 문자열로 변환한 숫자의 자릿수를 가지고 숫자에 맞는 영어단어로 변환 
				case '0': //0인경우 zero 에서 비교에 필요없는 ero는 지우고 z만 입력
					sb.append("z");
					break;
				case '1':
					sb.append("o");
					break;
				case '2':
					sb.append("tw");
					break;
				case '3':
					sb.append("th");
					break;
				case '4':
					sb.append("fo");
					break;
				case '5':
					sb.append("fi");
					break;
				case '6':
					sb.append("si");
					break;
				case '7':
					sb.append("se");
					break;
				case '8':
					sb.append("e");
					break;
				case '9':
					sb.append("n");
					break;
				}
			}
			arr[i-M][0] =  sb.toString(); //스트링 빌더에 추가된 영어로 변환된 문자열을  배열에 할당 
			arr[i-M][1] =  temp; //스트링 타입 숫자 문자열을  배열에 할당 
		}
		Arrays.sort(arr, (o1,o2)->o1[0].compareTo(o2[0])); //영어 문자열 순으로 (사전순) 으로 정렬
		sb.setLength(0); //스트링 빌더를 다시 사용하기 위해 초기화 
		for (int i = 0, j=1; i < arr.length; i++,j++) { //arr크기 만큼 반복 
			 // arr[i][0] == 영어로된 문자열  arr[i][1]==원래 숫자 
			sb.append(arr[i][1]).append(" ");//스트링 빌더에 누적  
			if(j%10==0) sb.append("\n");
		}
		System.out.println(sb); //스트링 빌더를 출력 
	}

}
