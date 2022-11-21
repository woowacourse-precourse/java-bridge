package Controller;

import bridge.*;
import view.InputView;
import view.OutputView;

public class BridgeGameController {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeGameController() {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    }

    public void gameStart() {
        Bridge bridge = getBridge();
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while (!bridgeGame.isClear()) {
            move(bridgeGame);
            OutputView.printMap(bridgeGame);
            if (bridgeGame.isFailure()) {
                restart(bridgeGame);
            }
        }
        OutputView.printResult(bridgeGame);
    }

    private void move(BridgeGame bridgeGame) {
        while (true) {
            try {
                String movePosition = InputView.readMoving();
                bridgeGame.move(movePosition);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_MESSAGE + exception.getMessage());
            }
        }
    }

    private void restart(BridgeGame bridgeGame) {
        while (true) {
            try {
                String restartCommand = InputView.readGameCommand();
                bridgeGame.retry(restartCommand);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_MESSAGE + exception.getMessage());
            }
        }
    }

    private Bridge getBridge() {
        while (true) {
            try {
                int bridgeSize = InputView.readBridgeSize();
                BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
                return new Bridge(bridgeMaker.makeBridge(bridgeSize));
            } catch (NumberFormatException exception) {
                System.out.println(ERROR_MESSAGE + "오직 숫자로만 이루어져 있어야 합니다.");
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_MESSAGE + exception.getMessage());
            }
        }
    }
}
