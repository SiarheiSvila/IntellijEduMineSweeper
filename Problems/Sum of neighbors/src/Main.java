import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<List<Integer>> arrayList = new ArrayList<>();
        int m = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            String[] s = line.split(" ");
            List<Integer> list = Arrays.stream(s)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            m = list.size();
            arrayList.add(list);
        }
        int n = arrayList.size();

        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int iMinus1J = i == 0 ? arrayList.get(n-1).get(j) : arrayList.get(i-1).get(j);
                int iPlus1J = i == n - 1 ? arrayList.get(0).get(j) : arrayList.get(i+1).get(j);
                int iJMinus1 = j == 0 ? arrayList.get(i).get(m-1) : arrayList.get(i).get(j-1);
                int iJPlus1 = j == m -1 ? arrayList.get(i).get(0) : arrayList.get(i).get(j+1);
                res[i][j] = iMinus1J + iPlus1J + iJMinus1 + iJPlus1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j]+ " ");
            }
            System.out.println();
        }
    }
}