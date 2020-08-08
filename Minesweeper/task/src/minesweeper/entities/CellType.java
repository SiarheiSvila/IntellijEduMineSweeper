package minesweeper.entities;

import java.util.Arrays;

public enum CellType {
    EMPTY('.'),
    BOMB('X'),
    NUM_1('1'),
    NUM_2('2'),
    NUM_3('3'),
    NUM_4('4'),
    NUM_5('5'),
    NUM_6('6'),
    NUM_7('7'),
    NUM_8('8');

    private final char symbol;

    CellType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static CellType valueOfNumber(int num) {
        if (num == 0) {
            return EMPTY;
        }
        return Arrays.stream(CellType.values())
                .filter(s -> String.valueOf(s.getSymbol()).equals(String.valueOf(num)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("fucking  shit " + num));
    }
}
