import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++ ) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            if (k <= getAvailableSeatsAmount(arr[i])) {
                System.out.println(i+1);
                System.exit(0);
            }
        }
        System.out.println(0);
    }

    public static int getAvailableSeatsAmount(int[] seats) {
        List<Integer> seatsList = new ArrayList<>();
        int seatAmount = 0;
        for (int seat : seats) {
            if (seat == 0) {
                seatAmount++;
            } else {
                seatsList.add(seatAmount);
                seatAmount = 0;
            }
        }
        seatsList.add(seatAmount);
        return seatsList.stream().max(Integer::compareTo).get();
    }
}