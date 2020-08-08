package minesweeper;

public class Main {

    private static final InputScanner scanner = new InputScanner();
    private static final FieldGenerator fieldGenerator = new FieldGenerator();

    public static void main(String[] args) {
        System.out.print("How many mines do you want on the field? ");
        int bombAmount = scanner.getInt();
        fieldGenerator.generateField(bombAmount);
    }
}
