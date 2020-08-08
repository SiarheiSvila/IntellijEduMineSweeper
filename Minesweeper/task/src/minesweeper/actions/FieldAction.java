package minesweeper.actions;

import minesweeper.entities.Cell;
import minesweeper.entities.Field;

import java.util.Random;

public class FieldAction {
    private Random random = new Random();

    private int getLessFiledX(Field field) {
        int maxFreeCells = -1;
        int maxFreeCellX = -1;
        for (int x = 0; x < field.getxSize(); x++) {
            int freeCellsAmount = 0;
            for (int y = 0; y < field.getySize(); y++) {
                if (!field.isBomb(x, y)) {
                    freeCellsAmount++;
                }
            }
            if (freeCellsAmount > maxFreeCells) {
                maxFreeCellX = x;
                maxFreeCells = freeCellsAmount;
            }
        }
        return maxFreeCellX;
    }

    private Cell getFreeCellForX(Field field, int rowX) {
        int startingPoint = random.nextInt(field.getySize());
        while (field.isBomb(rowX, startingPoint)) {
            startingPoint = startingPoint == field.getySize()-1 ? 0 : startingPoint+1 ;
        }
        return field.get(rowX, startingPoint);
    }

    public Cell getFreeCell(Field field) {
        int lessFiledX = getLessFiledX(field);
        return getFreeCellForX(field, lessFiledX);
    }
}
