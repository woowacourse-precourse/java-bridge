package bridge.controller;

import bridge.constant.AfterMovingStatusConstant;
import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private int gameCount = 0;
    public void start() {
        BridgeGame bridgeGame = new BridgeGame(bridgeLengthInputView());
        while (true) {
            AfterMovingStatusConstant afterMovingStatusConstant = thisTurnGameStart(bridgeGame);
            if (afterMovingStatusConstant.isGameSuccess()) {
                return;
            }
        }
    }

    private AfterMovingStatusConstant thisTurnGameStart(BridgeGame bridgeGame) {
        gameCount += 1;
        bridgeGame.createThisTurnBridge();
        while (true) {
            AfterMovingStatusConstant movingStatus = bridgeGame.move(thisTurnMoveBridgeInputView());
            thisTurnMovingResult(bridgeGame.thisTurnBridge());
            if (movingStatus.isFinishThisTurn()) {
                return movingStatus;
            }
        }
    }

    private void thisTurnMovingResult(String thisTurnBridge) {
        outputView.printMap(thisTurnBridge);
    }


    private String thisTurnMoveBridgeInputView() {
        outputView.printChooseWhereToGoBridgeMessage();
        return inputView.readMoving();
    }

    private String bridgeLengthInputView() {
        outputView.gameStartMessage();
        return inputView.readBridgeSize();
    }
}
