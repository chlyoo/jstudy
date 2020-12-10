import java.util.Arrays;

class ArrayUtilize{
	public static void main(String[] args){
		
		int sum = 0;
		float average = 0f;

		int[] score= {100, 80, 65, 90, 88};

		for(int i = 0; i < score.length; i++){
			sum += score[i];
		}
		// average = sum / score.length;  이렇게 하면 버림이 된다.  한쪽을 float으로 변형시켜야
		average = sum / (float) score.length;
		System.out.println("Sum: " +sum);
		System.out.println("Average: " + average);

		int[] numbers = {73, 23, 99, 33, 100, 55, 80, 65};
		int max = numbers[0];
		int min = numbers[0];
		for(int i = 1; i< numbers.length; i++){
			if(numbers[i] > max){
				max = numbers[i];
		}else if(numbers[i] < min){
			min = numbers[i];
		}
		}
		System.out.println("최댓값 : " + max);
		System.out.println("최소: " + min);
				
	}

}