package bridge;

import java.util.List;

public class OutputController {
    private static OutputView outputView = new OutputView();

    public void printMap(List<Bridge> bridges) {
        outputView.printMap(bridges);
    }

    public void printResult(List<Bridge> bridges, String gameResult, int count) {
        outputView.printResult(bridges, gameResult, count);
    }
}
