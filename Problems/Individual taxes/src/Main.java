import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt(); // reading a length
        int[] income = new int[len];  // creating an array with the specified length
        int[] taxes = new int[len];
        int[] sum = new int[len];

        for (int i = 0; i < len; i++) {
            income[i] = scanner.nextInt();
        }
        for (int i = 0; i < len; i++) {
            taxes[i] = scanner.nextInt();
        }

        for (int i = 0; i < len; i++) {
            sum[i] = income[i] * taxes[i];
        }

        int minIndex = 0;
        int max = sum[0];
        for (int i = 1; i < len; i++) {
            if (sum[i] > max) {
                max = sum[i];
                minIndex = i;
            }
        }
        System.out.println(minIndex+1);
    }
}