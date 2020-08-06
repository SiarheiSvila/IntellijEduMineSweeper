package minesweeper;

import minesweeper.entities.Cell;
import minesweeper.entities.Field;

import java.util.Random;

public class FieldGenerator {
    private Random random = new Random();

    private static final int FIELD_X_SIZE = 9;
    private static final int FIELD_Y_SIZE = 9;

    public void generateField(int fullBombAmount) {
        Field field = new Field(FIELD_X_SIZE, FIELD_Y_SIZE);
        for (int y = 0; y < field.getySize(); y++) {
            int bombsAmount = getCurrentRowsBombsAmount(field, fullBombAmount, y);
            for (int j = 0; j < bombsAmount; j++) {
                int bombPositionX = random.nextInt(field.getxSize());
                while (field.isBomb(bombPositionX, y)) {
                    bombPositionX = random.nextInt(field.getxSize());
                }
                field.setBomb(bombPositionX, y);
                fullBombAmount--;
            }
        }

        if (fullBombAmount != 0) {
            placeRemainingBombs(field, fullBombAmount);
        }

        field.printField();
    }

    private int getCurrentRowsBombsAmount(Field field, int fullBombAmount, int y) {
        int bombsAmount = fullBombAmount + 1;
        while (bombsAmount > fullBombAmount) {
            int avgBombsPerRow = fullBombAmount/(field.getySize()-y) == 0 ? 1 : fullBombAmount/(field.getySize()-y);
            bombsAmount = random.nextInt(avgBombsPerRow+1) + avgBombsPerRow/2;
        }
        bombsAmount = Math.min(bombsAmount, field.getxSize());
        return bombsAmount;
    }
    
    private void placeRemainingBombs(Field field, int bombAmount) {
        while (bombAmount != 0) {
            Cell freeCell = field.getFreeCell();
            field.setBomb(freeCell);
            bombAmount--;
        }
    }


}
