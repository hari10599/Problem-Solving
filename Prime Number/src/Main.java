import java.util.*;

public class Main {

    public static List<Integer> sieveOfEratosthenes(int n) {
        List<Integer> result = new ArrayList<>();
        int[] array = new int[n+1];
        for(int i = 2; i * i <= n; i++) {
            if(array[i] == 1)
                continue;
            for(int j = i * i; j <= n; j=j+i)
                array[j] = 1;
        }
        
        for(int i = 2; i <= n; i++) {
            if(array[i] != 1)
                result.add(i);
        }
        return result;
    }

    public static List<Integer> usingSquareRoot(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            int flag = 0;
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
                result.add(i);
        }
        return result;        
    }

    public static List<Integer> bruteForce(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            int j;
            for(j = 2; j <= i; j++) {
                if(i % j == 0)
                    break;
            }
            if(i == j)
                result.add(i);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int n = 100;
        System.out.println(bruteForce(n));
        System.out.println(usingSquareRoot(n));
        System.out.println(sieveOfEratosthenes(n));
        
    }
}
