package bridge.console;

import bridge.console.utility.MapDrawer;
import bridge.data.MoveResult;

import java.util.List;

public class OutputView {

    private final MapDrawer mapDrawer;

    public OutputView() {
        this.mapDrawer = new MapDrawer();
    }

    public void printMap(List<MoveResult> moveResults) {
        StringBuilder upperRow = new StringBuilder();
        StringBuilder lowerRow = new StringBuilder();
        this.mapDrawer.drawMap(moveResults, upperRow, lowerRow);

        System.out.println(upperRow + System.lineSeparator() + lowerRow + System.lineSeparator());
    }
}
