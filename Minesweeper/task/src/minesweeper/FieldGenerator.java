package minesweeper;

import minesweeper.entities.Field;
import minesweeper.placers.BombPlacer;
import minesweeper.placers.NumberPlacer;

public class FieldGenerator {

    private static final int FIELD_X_SIZE = 9;
    private static final int FIELD_Y_SIZE = 9;
    private static final BombPlacer bombPlacer = new BombPlacer();
    private static final NumberPlacer numberPlacer = new NumberPlacer();

    public void generateField(int bombAmount) {
        if (bombAmount >= FIELD_X_SIZE*FIELD_Y_SIZE) {
            throw new IllegalArgumentException("Too much mines");
        }
        Field field = new Field(FIELD_X_SIZE, FIELD_Y_SIZE);
        bombPlacer.placeBombs(field, bombAmount);
        numberPlacer.placeNumbers(field);
        field.printField();
    }
}
