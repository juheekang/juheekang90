 package Exercise;

import java.util.Arrays;
import java.util.Collection;

public class Exercise51 {

	public static void main(String[] args) {
//		다음 배열에서 최댓값과 최솟값을 구하시오.
//		{38, 94, 16, 3, 76, 94, 82, 47, 59, 8}
//최대값은 가장작은수에서 시작 최소값은 가장큰수에서 시작
		int [] array = {38, 94, 16, 3, 76, 94, 82, 47, 59, 8};
//		Integer[] array = {38, 94, 16, 3, 76, 94, 82, 47, 59, 8};
		int max = Integer.MIN_VALUE; //int max = array[0];
		int min = Integer.MAX_VALUE; //int min = array[0];
		
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
			if (min > array[i]) {
				min = array[i];
			}
			
		}
		System.out.println("최대값:" + max);
		System.out.println("최소값:" + min);
//		System.out.println("최대값(메소드이용): " + Collection.max(Arrays.asList(scores)));
//		System.out.println("최소값(메소드이용): " + Collection.min(Arrays.asList(scores)));
	}

}
