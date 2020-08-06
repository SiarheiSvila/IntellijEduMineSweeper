package minesweeper.entities;

import minesweeper.actions.FieldAction;

public class Field {
    private FieldAction fieldAction;
    
    private final int xSize;
    private final int ySize;
    private char[][] field;

    public Field(int xSize, int ySize) {
        fieldAction = new FieldAction();
        
        this.xSize = xSize;
        this.ySize = ySize;
        field = new char[xSize][ySize];
        generateEmptyField();
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }
    
    public void setBomb(Cell cell) {
        field[cell.getX()][cell.getY()] = 'X';
    }

    public void setBomb(int x, int y) {
        field[x][y] = 'X';
    }

    public boolean isBomb(Cell cell) {
        return field[cell.getX()][cell.getY()] == 'X';
    }

    public boolean isBomb(int x, int y) {
        return field[x][y] == 'X';
    }

    public void printField() {
        for (char[] rows : field) {
            for (char cell : rows) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
    
    private void generateEmptyField() {
        for (int y = 0; y < xSize; y++) {
            for (int x = 0; x < ySize; x++) {
                field[y][x] = '.';
            }
        }
    }

    public Cell getFreeCell() {
        int lessFiledX = fieldAction.getLessFiledX(this);
        return fieldAction.getFreeCellForX(this, lessFiledX);
    }
}
