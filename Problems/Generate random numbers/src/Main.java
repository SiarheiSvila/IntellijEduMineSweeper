import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        final int a = scanner.nextInt();
        final int b = scanner.nextInt();

        final Random random = new Random(a + b);
        int sum = 0;

        while (n-- > 0) {
            sum += random.nextInt(b + 1 - a) + a;
        }

        System.out.println(sum);
    }
}