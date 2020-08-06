import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int BOX_SIDES = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] box1 = new int[BOX_SIDES];
        int[] box2 = new int[BOX_SIDES];

        for (int i = 0; i < BOX_SIDES; i++) {
            box1[i] = scanner.nextInt(); // read the next number of the array
        }

        for (int i = 0; i < BOX_SIDES; i++) {
            box2[i] = scanner.nextInt(); // read the next number of the array
        }
        Arrays.sort(box1);
        Arrays.sort(box2);

        if (box1[0] == box2[0] && box1[1] == box2[1] && box1[2] == box2[2]) {
            System.out.println("Box 1 = Box 2");
        } else if (box1[0] >= box2[0] && box1[1] >= box2[1] && box1[2] >= box2[2]) {
            System.out.println("Box 1 > Box 2");
        } else if (box1[0] <= box2[0] && box1[1] <= box2[1] && box1[2] <= box2[2]) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incomparable");
        }
    }
}