package bridge.view;

import bridge.controller.GameFlag;
import bridge.domain.ResultFlag;
import bridge.domain.Map;
import bridge.domain.UpDownFlag;

public class BridgeView {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void printStartMessage() {
        outputView.printGameStartMessage();
    }

    public int receiveBridgeSize() {
        while (true) {
            try {
                outputView.printEnterBridgeLength();
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    public UpDownFlag receiveMoving() {
        while (true) {
            try {
                outputView.printEnterSelectMoving();
                String input = inputView.readMoving();
                return UpDownFlag.ofString(input);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    public void printMap(Map map) {
        outputView.printMap(map);
    }

    public GameFlag receiveRestart() {
        while (true) {
            try {
                outputView.printRestartOrQuitMessage();
                String input = inputView.readGameCommand();
                return GameFlag.ofString(input);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    public void printResult(Map map, ResultFlag result, int tryCount) {
        outputView.printResult(map, result, tryCount);
    }
}
