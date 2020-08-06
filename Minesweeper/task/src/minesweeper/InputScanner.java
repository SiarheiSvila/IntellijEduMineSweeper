package minesweeper;

import java.util.Scanner;

public class InputScanner {
    private Scanner scanner;

    public InputScanner() {
        scanner = new Scanner(System.in);
    }

    public int getInt() {
        return scanner.nextInt();
    }
}
