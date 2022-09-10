package easy;

import java.util.Arrays;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {

		int[] indices = new int[2];

		for (int indexStart = 0; indexStart < nums.length; indexStart++) {
			int numStart = nums[indexStart];
			for (int indexEnd = 0; indexEnd < nums.length; indexEnd++) {
				if (indexStart == indexEnd)
					continue;
				int numEnd = nums[indexEnd];
				if (numStart + numEnd == target) {
					indices[0] = indexStart;
					indices[1] = indexEnd;
					break;
				}
			}
		}

		return indices;
	}

	public static void main(String[] args) {
		System.out.println("_________________");

		int[] nums = new int[] { 3, 3 };
		int target = 6;

		int[] result = twoSum(nums, target);
		System.out.println("_________________result -> " + Arrays.toString(result));

	}
}
