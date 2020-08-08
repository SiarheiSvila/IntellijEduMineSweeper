package minesweeper.placers;

import minesweeper.entities.Cell;
import minesweeper.entities.Field;

import java.util.Random;

public class BombPlacer {

    private Random random = new Random();

    public void placeBombs(Field field, int fullBombAmount) {
        for (int x = 0; x < field.getySize(); x++) {
            int bombsAmount = getCurrentRowsBombsAmount(field, fullBombAmount, x);
            for (int i = 0; i < bombsAmount; i++) {
                int bombPositionX = random.nextInt(field.getxSize());
                while (field.isBomb(bombPositionX, x)) {
                    bombPositionX = random.nextInt(field.getxSize());
                }
                field.setBomb(bombPositionX, x);
                fullBombAmount--;
            }
        }

        if (fullBombAmount != 0) {
            placeRemainingBombs(field, fullBombAmount);
        }
    }

    private int getCurrentRowsBombsAmount(Field field, int fullBombAmount, int currentRowIndex) {
        int bombsAmount = fullBombAmount + 1;
        while (bombsAmount > fullBombAmount) {
            int avgBombsPerRow = fullBombAmount/(field.getySize()-currentRowIndex) == 0 ? 1 : fullBombAmount/(field.getySize()-currentRowIndex);
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
