class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while(start < end) {
            while(start < end && !Character.isLetterOrDigit(chars[start])) {
                start++;
            }

            while(end > start && !Character.isLetterOrDigit(chars[end])) {
                end--;
            }

            // System.out.println(chars[start]);
            // System.out.println(chars[end]);

            if (Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end])) {
                return false;
            }

            start++;
            end--;
        }
        
        return true;
    }
}
