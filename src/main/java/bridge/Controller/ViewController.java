package bridge.Controller;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class ViewController {
    public int getBridgeSize() {
        return InputView.readBridgeSize();
    }

    public String getMovement() {
        return InputView.readMoving();
    }

    public String getCommand() {
        return InputView.readGameCommand();
    }

    public void printMap(List<String> moveOutput) {
        OutputView.printMap(moveOutput);
    }

    public void getPrintResult(int gameCount, List<String> currentBridge, boolean isSuccess) {
        OutputView.printResult(gameCount, currentBridge, isSuccess);
    }

}
