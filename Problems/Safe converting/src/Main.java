import java.util.Scanner;

public class Main {

    public static int convert(Long val) {
        int res;
        if (val == null) {
            res = 0;
        } else if (val > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        } else if (val < Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        } else {
            res = Math.toIntExact(val);
        }
        return res;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        Long longVal = "null".equals(val) ? null : Long.parseLong(val);
        System.out.println(convert(longVal));
    }
}