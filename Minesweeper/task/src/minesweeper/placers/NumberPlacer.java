package minesweeper.placers;

import minesweeper.entities.Cell;
import minesweeper.entities.CellType;
import minesweeper.entities.Field;

import java.util.HashSet;
import java.util.Set;

public class NumberPlacer {

    public void placeNumbers(Field field) {
        for (Cell[] rows : field.getField()) {
            for (Cell cell : rows) {
                int num = countSurroundingMinesForCell(cell, field);
                if (!field.isBomb(cell)) {
                    cell.setCellType(CellType.valueOfNumber(num));
                }
            }
        }
    }

    private int countSurroundingMinesForCell(Cell cell, Field field) {
        Set<Cell> surroundingCells = new HashSet<>();

        boolean upperRowExists = cell.getX() != 0;
        boolean lowerRowExists = cell.getX() != field.getxSize()-1;
        boolean leftColumnExists = cell.getY() != 0;
        boolean rightColumnExists = cell.getY() != field.getySize()-1;

        if (upperRowExists) {
            surroundingCells.add(field.get(cell.getX()-1, cell.getY()));
            if (leftColumnExists) {
                surroundingCells.add(field.get(cell.getX()-1, cell.getY()-1));
            }
            if (rightColumnExists) {
                surroundingCells.add(field.get(cell.getX()-1, cell.getY()+1));
            }
        }
        if (lowerRowExists) {
            surroundingCells.add(field.get(cell.getX()+1, cell.getY()));
            if (leftColumnExists) {
                surroundingCells.add(field.get(cell.getX()+1, cell.getY()-1));
            }
            if (rightColumnExists) {
                surroundingCells.add(field.get(cell.getX()+1, cell.getY()+1));
            }
        }
        if (leftColumnExists) {
            surroundingCells.add(field.get(cell.getX(), cell.getY()-1));
        }
        if (rightColumnExists) {
            surroundingCells.add(field.get(cell.getX(), cell.getY()+1));
        }

        return (int) surroundingCells.stream()
                .filter(c -> c.getCellType() == CellType.BOMB)
                .count();
    }
}
