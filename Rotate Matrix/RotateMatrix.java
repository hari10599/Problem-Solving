qclass RotateMatrix {
   public static void main(String[] args) {
        // TODO code application logic here
            //or transpose matrix and swap(left,right)
        int[][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        for(int i = 0; i < a.length/2; i++) {
            for(int j = i; j < a.length-1-i; j++) {
                int temp = a[i][j];
                a[i][j] = a[a.length-1-j][i];
                a[a.length-1-j][i] = a[a.length-1-i][a.length-1-j];
                a[a.length-1-i][a.length-1-j] = a[j][a.length-1-i];
                a[j][a.length-1-i] = temp;
                
            }
            
        }
        for(int i = 0;i<a.length;i++) {
            for(int j = 0;j<a.length;j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}