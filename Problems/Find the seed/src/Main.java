import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Seed> maxSeeds = new ArrayList<>();
        for (int seed = a; seed<=b; seed++) {
            Random random = new Random(seed);
            int maxNumber = -1;
            for (int j = 0; j < n; j++) {
                int randNumber = random.nextInt(k);
                if (randNumber > maxNumber) {
                    maxNumber = randNumber;
                }
            }
            maxSeeds.add(new Seed(seed, maxNumber));
        }
        Seed seed = maxSeeds.stream()
                .sorted(Comparator.comparing(Seed::getMaxValue)
                        .thenComparing(Seed::getSeed))
                .findFirst()
                .get();

        System.out.println(seed.seed);
        System.out.println(seed.maxValue);
    }
}

class Seed {
    int seed;
    int maxValue;

    public Seed(int seed, int maxValue) {
        this.seed = seed;
        this.maxValue = maxValue;
    }

    public int getSeed() {
        return seed;
    }

    public int getMaxValue() {
        return maxValue;
    }
}