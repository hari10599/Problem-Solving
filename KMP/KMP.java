class KMP {
    public static void computeLps(String pattern, int[] lps) {
        int i = 1;
        int j = 0;
        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            }
            else {
                if(j != 0) {
                    j = lps[j - 1];
                }
                else {
                    lps[i] = 0;
                    j = 0;
                    i++;       
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "AAAAABAAABA";
        String pattern = "AAAA";
        int[] lps = new int[pattern.length()];
        computeLps(pattern, lps);
        int i = 0;
        int j = 0;
        while(i < text.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if(j == pattern.length()) {
                System.out.println("Pattern found at : " + (i - pattern.length()));
                j = lps[pattern.length() - 1];
                continue;
            }
            if(i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if(j != 0) 
                    j = lps[j -1];
                else {
                    j = 0;
                    i++;
                }
            }

        }
    }
}