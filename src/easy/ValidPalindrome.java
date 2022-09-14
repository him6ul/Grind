package easy;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {

		if (s == null)
			return false;

		if (s.trim().length() == 0)
			return true;

		s = s.toLowerCase();
		s = s.replaceAll("[^a-zA-Z0-9]", "");

		char[] charArray = s.toCharArray();

		int j = charArray.length - 1;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != charArray[j--])
				return false;
		}

		return true;

	}

	public static void main(String[] args) {
		System.out.println("___________________");

		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		String s3 = " ";

		ValidPalindrome palindrome = new ValidPalindrome();

		System.out.println("___________________ Result 1 -> " + palindrome.isPalindrome(s1));
		System.out.println("___________________ Result 2 -> " + palindrome.isPalindrome(s2));
		System.out.println("___________________ Result 3 -> " + palindrome.isPalindrome(s3));

	}
}
