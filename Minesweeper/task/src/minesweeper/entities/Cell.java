package minesweeper.entities;

public class Cell {
    private int x;
    private int y;
    private CellType cellType;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        cellType = CellType.EMPTY;
    }

    public String getCoordinates() {
        return x + " " + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    boolean isBomb() {
        return cellType == CellType.BOMB;
    }
}
