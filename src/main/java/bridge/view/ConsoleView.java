package bridge.view;

import bridge.domain.BridgeOfUser;
import java.rmi.server.ExportException;

public class ConsoleView {
    private final InputView inputView;
    private final OutputView outputView;

    public ConsoleView() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void showGameStart() {
        outputView.printGameStartComment();
    }

    public int requestBridgeSize() {
        try {
            outputView.printRequestBridgeSizeComment();
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return requestBridgeSize();
        }
    }

    public String requestMove() {
        try {
            outputView.printRequestMoveSideComment();
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return requestMove();
        }
    }

    public void showNowBridge(BridgeOfUser userMap) {
        outputView.printMap(userMap);
    }

    public String requestRetry() {
        try {
            outputView.printRequestRetryComment();
            return inputView.readRetry();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return requestRetry();
        }
    }

    public void showResult(BridgeOfUser userMap, String failOrSuccess, int tryCount) {
        outputView.printResultComment();
        outputView.printMap(userMap);
        outputView.printResult(failOrSuccess, tryCount);
    }

}
