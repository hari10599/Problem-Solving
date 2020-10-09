

public class App {
    public static boolean isPrime(int prime) {
        for(int i = 2; i * i < prime; i++) {
            if(prime % i == 0)
                return false;
        }
        return true;
    }

    static void checkSubstring(int pattern_hash, int text_hash, int index, String text, String pattern) {
        if(pattern_hash == text_hash) {
            for(int i = 0; i < pattern.length(); i++) {
                if(pattern.charAt(i) != text.charAt(i+index))
                    return;
            }
            System.out.println("Pattern found at : " + index);
        }
    }

    static int characterValue(String s, int i) {
        return (int)s.charAt(i); 
    }

    static void rabinKarp(String text, String pattern, int prime) {
        if(pattern.length() > text.length())
            return;
        int base = 256;
        int m = pattern.length() - 1;
        int pattern_hash = 0;
        int text_hash = 0;
        
        for(int i = 0; i < pattern.length(); i++) {
            pattern_hash+= characterValue(pattern, i) * (int)Math.pow(base, i);
            text_hash+=characterValue(text, i) * (int)Math.pow(base, i);
        }
        checkSubstring(pattern_hash, text_hash, 0, text, pattern);

        for(int i = pattern.length(); i < text.length(); i++) {
            text_hash =  text_hash - characterValue(text, i - pattern.length());
            text_hash = text_hash / base;
            text_hash += characterValue(text, i) * (int)Math.pow(base, m);
            checkSubstring(pattern_hash, text_hash, i - pattern.length() + 1, text, pattern);

        }
        
    }


    public static void main(String[] args) throws Exception {
        String text = "AABAACAADAABAABA";
        String pattern = "AA";
        int prime = 199;
        System.out.println(isPrime(prime));
        rabinKarp(text, pattern, prime);
    }
}
