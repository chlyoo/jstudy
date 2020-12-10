import java.util.Arrays;

class ArrayDeclararation{
	public static void main(String[] args){
		// 두줄로 선언
		int[] score1; //배열 선언 (참조변수의 선언)
		score1 = new int[5]; //배열 생성
		// 한줄로 선언
		int[] score2 =new int[5];
		score[3]= 100; //배열에 값 넣기
		System.out.println("score1" + Arrays.toString(score));  
		System.out.println("score2" + Arrays.toString(score2));
	}
}