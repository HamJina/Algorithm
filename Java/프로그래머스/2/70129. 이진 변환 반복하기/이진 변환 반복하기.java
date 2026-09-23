class Solution {
    private static int count = 0;
    private static int minus = 0;
    public int[] solution(String s) {
        while(!s.equals("1")) {
            // 0 제거
            s = minusZero(s);
        
            if(s.startsWith("0")) {
                s = s.substring(1, s.length());
            }
            s = binary(s.length());
        }

        return new int[]{count, minus};
    }

    private static String minusZero(String str) {
        int prev_length = str.length();
        str = str.replace("0", "");
        int post_length = str.length();
        minus += prev_length - post_length;
        return isStartsZero(str);
    }

    private static String binary(int num) {
        count++;
        int n = num;
        StringBuilder sb = new StringBuilder();
        while(n / 2 != 0) {
            sb.append(n % 2);
            n /= 2;
        }
        sb.append(n % 2);
        return isStartsZero(sb.reverse().toString());
    }
    
    private static String isStartsZero(String str) {
        if(str.startsWith("0")) {
                return str.substring(1, str.length());
        }
        return str;
    }
}