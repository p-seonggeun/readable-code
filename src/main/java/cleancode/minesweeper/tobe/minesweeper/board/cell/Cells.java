package cleancode.minesweeper.tobe.minesweeper.board.cell;

import java.util.Arrays;
import java.util.List;

public class Cells {

    private final List<Cell> cells;

    private Cells(List<Cell> cells) {
        this.cells = cells;
    }

    public static Cells of(List<Cell> cells) {
        return new Cells(cells);
    }


    public static Cells from(Cell[][] cells) {
        List<Cell> cellList = Arrays.stream(cells)
                .flatMap(c -> Arrays.stream(c))
                .toList();

        return of(cellList);
    }

    public boolean isAllChecked() {
        return cells.stream()
                .allMatch(cell -> cell.isChecked());
    }
}
