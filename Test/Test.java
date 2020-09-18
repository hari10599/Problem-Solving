
class Test {
    public static void main(String[] args) {
        String s1 = "100";
        String s2 = "1";
        int i = s1.length() -1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder sb =  new StringBuilder();
        while(i >= 0 && j >= 0) {
            int f = s1.charAt(i)-'0';
            int s = s2.charAt(j)-'0';
            int sum = f+s+carry;
            sb.append(String.valueOf(sum/2));
            carry = sum % 2;
            i--;
            j--;
        }
        while(i >= 0) {
            int f = s1.charAt(i)-'0' + carry;
            String s = f/2+"";
            sb.append(String.valueOf(f/2));
            carry = f % 2;
            i--;
        }
        while(j >= 0) {
            int f = s2.charAt(j)-'0' + carry;
            String s = f/2+"";
            sb.append(String.valueOf(f/2));
            carry = f % 2;
            j--;
        }
        System.out.println(sb.reverse());
    }
}