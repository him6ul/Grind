package easy;

public class BinarySearch {
    public int search(int[] nums, int target) {

        int end = nums.length;
        int start = 0;
        int mid = -1;

        while (start <= end) {
            mid = (start + end) / 2;
            int check = nums[mid];
            if (check == target)
                return mid;

            if (start == mid)
                return -1;

            if (check > target)
                end = mid;
            else
                start = mid;
        }
        return mid;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums1 = new int[]{-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        int placeHolder1 = binarySearch.search(nums1, target1);
        System.out.println("____________________ placeHolder1 -> " + placeHolder1);

        int[] nums2 = new int[]{-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        int placeHolder2 = binarySearch.search(nums2, target2);
        System.out.println("____________________ placeHolder2 -> " + placeHolder2);

        int[] nums3 = new int[]{5};
        int target3 = -5;
        int placeHolder3 = binarySearch.search(nums3, target3);
        System.out.println("____________________ placeHolder3 -> " + placeHolder3);

        int[] nums4 = new int[]{-1, 0, 3, 5, 9, 12};
        int target4 = 12;
        int placeHolder4 = binarySearch.search(nums4, target4);
        System.out.println("____________________ placeHolder4 -> " + placeHolder4);

        int[] nums5 = new int[]{5};
        int target5 = 5;
        int placeHolder5 = binarySearch.search(nums5, target5);
        System.out.println("____________________ placeHolder5 -> " + placeHolder5);
    }
}
