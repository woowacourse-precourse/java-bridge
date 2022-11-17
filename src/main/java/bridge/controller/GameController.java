package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public GameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void start() {
        outputView.startGame();
        int bridgeSize = inputView.readBridgeSize();
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        bridgeGame.createBridge(bridgeSize);

        for (int index = 0; index < bridgeSize; index++) {
            outputView.askMoveSpace();
            String moveSpace = inputView.readMoving();

            String updateMoveResult = bridgeGame.move(moveSpace, index);
            outputView.printMap(updateMoveResult);

            if (bridgeGame.canNotMove()) {
                outputView.askRetry();
                String gameCommand = inputView.readGameCommand();
                String retryResult = bridgeGame.retry(gameCommand);
                if (!retryResult.equals("continue")) {
                    outputView.printResult(retryResult);
                    break;
                }
                index = -1;
            }
            if (index == bridgeSize - 1) {
                outputView.printResult(bridgeGame.getFinishResult());
            }
        }
    }
}
