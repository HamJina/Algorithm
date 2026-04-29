class Solution {
    public long solution(int w, int h) {
        long lw = (long) w;
        long lh = (long) h;
        
        return (lw * lh) - (lw + lh - gcd(lw, lh));
    }
    
    public long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}