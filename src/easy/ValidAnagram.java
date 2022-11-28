package easy;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";

        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {

        if (s == null && t == null)
            return true;

        if (s.length() != t.length())
            return false;

        char[] sArr = s.toCharArray();

        for (int index = 0; index<sArr.length; index++)
            t = t.replaceFirst(""+sArr[index], "");

        if (t.trim().length() > 0)
            return false;

        return true;
    }
}
