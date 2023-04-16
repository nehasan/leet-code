public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = new char[200001];
        int charLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
                chars[charLen++] = Character.toLowerCase(c);
            }
        }

        for (int i = 0, j = (charLen - 1); i < (charLen / 2); i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }

        return true;
    }
    public void func() {
//        System.out.println(isPalindrome("AMMA"));
//        System.out.println(isPalindrome("MOM"));
        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome(" "));
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static void main (String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        vp.func();
    }
}
