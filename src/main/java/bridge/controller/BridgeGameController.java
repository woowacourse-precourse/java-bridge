package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private boolean isSuccess = true;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void playBridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridgeGame.setBridge(inputView.readBridgeSize());
        enterMoving();
        outputView.printResult(isSuccess, bridgeGame.getTotalNumberOfAttempts());
    }

    public void enterMoving() {
        while (bridgeGame.isGameContinue()) {
            String moving = inputView.readMoving();
            if (bridgeGame.move(moving)) {
                outputView.printMap(bridgeGame.getCount(), moving, true);
                continue;
            }
            outputView.printMap(bridgeGame.getCount() + 1, moving, false);
            enterGameCommand();
            break;
        }
    }

    public void enterGameCommand() {
        if (bridgeGame.retry(inputView.readGameCommand())) {
            outputView = new OutputView();
            enterMoving();
            return;
        }
        isSuccess = false;
    }
}
