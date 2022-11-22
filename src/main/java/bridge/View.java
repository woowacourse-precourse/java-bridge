package bridge;

import java.util.List;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public int gameStartView() {
        outputView.printStartEventMessage();
        outputView.printBlankLine();
        outputView.printBridgeSizeEventMessage();
        int bridgeSize = this.inputView.readBridgeSize();
        outputView.printBlankLine();

        return bridgeSize;
    }

    public String moveView() {
        outputView.printMoveEventMessage();
        String moving = inputView.readMoving();

        return moving;
    }

    public void mapView(List<String> map) {
        outputView.printMap(map);
    }

    public String retryView() {
        outputView.printRetryEventMessage();
        String retryCommand = inputView.readGameCommand();

        return retryCommand;
    }

    public void closeView(
            List<String> map,
            int tryCount,
            boolean isCorrectPath
    ) {
        outputView.printResult(map, tryCount, isCorrectPath);
    }
}
