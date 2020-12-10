import java.util.Arrays;

class ArrayInit{
	public static void main(String[] args){
		int[] score = new int[5];	
		int tmp = score.length; //배열이름.length 배열의 길이(int형 상수)
		System.out.println(tmp); //한번 생성하면 길이 변경 불가

		score[0] = 50;
		score[1] = 60;
		score[2] = 70;
		score[3] = 80;
		score[4] = 90;
		// for문으로도 초기화 가능
		int[] score_for = new int[5];
		for(int i=0;i<score_for.length; i++){
			score_for[i] = i * 10 + 50;
		}
		//더 간단한 방법(강추)
		int[] score_ele = {50, 60, 70, 80, 90};

		System.out.println("score "+Arrays.toString(score));
		System.out.println("for문 "+Arrays.toString(score_for));
		System.out.println("간단하게 "+Arrays.toString(score_ele));
	}
}