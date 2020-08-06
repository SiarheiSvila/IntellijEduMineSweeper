import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // reading a length
        int m = scanner.nextInt(); // reading a length
        
        int[][] arr = new int[n][m]; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        
        int maxI = 0;
        int maxJ = 0;
        int max = arr[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        System.out.println(maxI + " " + maxJ);
    }
}