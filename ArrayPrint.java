import java.util.Arrays;

class ArrayPrint{
	public static void main(String[] args){
		
		int[] iArr = {50, 60, 70, 80, 90};
		char[] chArr = {'j','a','v','a'};

		System.out.println(iArr);  //이렇게 하면 주소가 출력됨
		
		for( int i=0; i< iArr.length; i++){
			System.out.print(iArr[i]+",");
		} //for문 이용 하나씩 출력
		System.out.println();
		
		System.out.println(Arrays.toString(iArr));  //toString 이용
		System.out.println(chArr); //캐릭터 배열의 경우 정상 출력

				
	}
}