package easy;

public class ValidParentheses {

	public static boolean isValid(String s) {

		boolean checkPaths = true;
		char[] charArrays = s.toCharArray();

		int position = 0;
		char[] bracketsArray = new char[s.length()];

		process: for (char charItem : charArrays) {
			switch (charItem) {
			case '{':
				bracketsArray[position++] = '{';
				break;
			case '(':
				bracketsArray[position++] = '(';
				break;
			case '[':
				bracketsArray[position++] = '[';
				break;
			case '}':

				if (position > 0 && bracketsArray[position - 1] == '{') {
					position--;
				} else {
					checkPaths = false;
					break process;
				}

				break;
			case ')':
				if (position > 0 && bracketsArray[position - 1] == '(') {
					position--;
				} else {
					checkPaths = false;
					break process;
				}

				break;
			case ']':
				if (position > 0 && bracketsArray[position - 1] == '[') {
					position--;
				} else {
					checkPaths = false;
					break process;
				}

				break;
			default:
				break;
			}
		}

		if (checkPaths && position == 0)
			return true;
		return false;
	}

	public static void main(String[] args) {

		String string = "]";
		System.out.println("_________________" + isValid(string));
	}

}
