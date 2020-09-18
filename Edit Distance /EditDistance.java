import java.util.*;
class EditDistance {
    static int findEditDistance(String a, String b) {
        int [][]dp = new int[a.length()+1][b.length()+1];

        for(int i = 1; i <= a.length(); i++) 
            dp[i][0] = dp[i-1][0] + 1;

        for(int j = 1; j <= b.length(); j++) 
            dp[0][j] = dp[0][j-1] + 1; 

        for(int i = 1; i <= a.length(); i++) {
            char aChar  = a.charAt(i-1);
            for(int j = 1; j <= b.length(); j++) {
                char bChar = b.charAt(j-1);
                if(aChar != bChar) {
                    int insertCost = 1 + dp[i][j-1];
                    int deleteCost = 1 + dp[i-1][j];
                    int replaceCost = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(insertCost, Math.min(deleteCost, replaceCost));
                }
                else {
                    dp[i][j] = dp[i-1][j-1];
                }

            }
        }
        //print(dp);
        printSteps(dp, a, b);
        return dp[a.length()][b.length()];
    }

    static void printSteps(int[][] dp, String a, String b) {
        Stack<String> steps = new Stack<>();
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        while (i > 0 || j > 0) {
            char aChar = i-1 >= 0 ? a.charAt(i-1): ' ';
            char bChar = j-1 >= 0 ? b.charAt(j-1): ' ';
            if(aChar!= bChar) {
                if(j > 0 && dp[i][j-1]+1 == dp[i][j]) {
                    steps.push("Insert "+ bChar);
                    j--;
                }
                else if(i > 0 && dp[i-1][j]+1 == dp[i][j]) {
                    steps.push("Delete "+aChar);
                    i--;
                }
                else {
                    steps.push("Replace "+aChar+" with "+bChar);
                    i--;
                    j--;
                }
            }
            else {
                i--;
                j--;
            }

        }
        while(!steps.isEmpty()) {
            System.out.println(steps.pop());
        }
    }




    static void print(int[][] dp) {
        for(int[] i: dp) {
            for(int j: i) {
                System.out.print(j+" ");
            }
            System.out.println();

        }
    }


    public static void main(String[] args) {
        String a = "bcd";
        String b = "abc";
        //a to b
        System.out.println(findEditDistance(a, b));
    }
}