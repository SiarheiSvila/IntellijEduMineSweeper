import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = readArrayList(scanner);
        int n = scanner.nextInt();
        inputList.sort(Comparator.comparing(Function.identity()));

        int minDifference = Math.abs(inputList.get(0) - n);
        for (int i : inputList) {
            if (Math.abs(i - n) < minDifference) {
                minDifference = Math.abs(i - n);
            }
        }

        int finalMinDifference = minDifference;
        String result = inputList.stream()
                .filter(i -> Math.abs(i - n) == finalMinDifference)
                .map(Objects::toString)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}