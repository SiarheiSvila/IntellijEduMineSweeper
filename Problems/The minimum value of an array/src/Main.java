import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt(); // reading a length
        int[] array = new int[len];  // creating an array with the specified length

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt(); // read the next number of the array
        }

        int minElement = array[0];
        for (int i = 1; i < len; i++) {
            if (minElement > array[i]) {
                minElement = array[i];
            }
        }
        System.out.println(minElement);
    }
}