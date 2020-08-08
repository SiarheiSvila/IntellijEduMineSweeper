package minesweeper.entities;

import minesweeper.actions.FieldAction;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private FieldAction fieldAction = new FieldAction();
    
    private final int xSize;
    private final int ySize;
    private final Cell[][] field;
    private final List<Cell> bombs = new ArrayList<>();

    public Field(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        field = new Cell[xSize][ySize];
        generateEmptyField();
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public Cell[][] getField() {
        return field;
    }

    public Cell get(int x, int y) {
        return field[x][y];
    }

    public List<Cell> getBombs() {
        return bombs;
    }

    public void setBomb(Cell cell) {
        cell.setCellType(CellType.BOMB);
        bombs.add(cell);
    }

    public void setBomb(int x, int y) {
        Cell cell = get(x, y);
        cell.setCellType(CellType.BOMB);
        bombs.add(cell);
    }

    public boolean isBomb(int x, int y) {
        Cell cell = get(x, y);
        return cell.isBomb();
    }

    public boolean isBomb(Cell cell) {
        return cell.isBomb();
    }

    public void printField() {
        for (Cell[] rows : field) {
            for (Cell cell : rows) {
                System.out.print(cell.getCellType().getSymbol());
            }
            System.out.println();
        }
    }

    private void generateEmptyField() {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                field[x][y] = new Cell(x, y);
            }
        }
    }

    public Cell getFreeCell() {
        return fieldAction.getFreeCell(this);
    }
}
