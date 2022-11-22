package bridge.controller;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeMaker;
import bridge.domain.bridge.BridgeNumberGenerator;
import bridge.domain.game.BridgeGame;
import bridge.util.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker;
    Bridge bridge;
    BridgeGame bridgeGame;
    boolean isSuccess, restart;


    public BridgeGameController(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void start() {
        outputView.printStartGuide();
        bridge = createBridge();

        firstRoundStart();

        while (restart) {
            restartRoundStart();
        }

         outputView.printFinalResult(bridgeGame, isSuccess);
    }

    private Bridge createBridge() {
        outputView.printInputBridgeLengthGuide();
        int bridgeLength = readBridgeLength();

        return new Bridge(bridgeMaker.makeBridge(bridgeLength));
    }

    private int readBridgeLength() {
        for (int tryCnt = 1; tryCnt <= 2; tryCnt++) {
            try {
                return inputView.readBridgeLength();
            } catch (IllegalArgumentException e) {
                callRetryGuide(tryCnt, 2, e);
            }
        }
        throw new IllegalArgumentException("[ERROR] 입력 시도 횟수 초과");
    }

    private void firstRoundStart() {
        bridgeGame = new BridgeGame(bridge);
        newRoundStart();
    }

    private void newRoundStart() {
        isSuccess = getRoundResultAndPrintMap();
        restart = getIsNeedRestart(isSuccess);
    }

    private boolean getRoundResultAndPrintMap() {
        boolean isSuccessMove;
        do{
            outputView.printInputMovingGuide();
            String moving = readMoving();
            isSuccessMove = bridgeGame.move(moving);

            outputView.printMap(bridgeGame.getGameResult());
        } while (isSuccessMove && bridgeGame.isUserCanMove());

        return isSuccessMove;
    }

    private String readMoving() {
        for (int tryCnt = 1; tryCnt <= 2; tryCnt++) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                callRetryGuide(tryCnt, 2, e);
            }
        }
        throw new IllegalArgumentException("[ERROR] 입력 시도 횟수 초과");
    }

    private boolean getIsNeedRestart(boolean isSuccess) {
        if (isSuccess) {
            return false;
        }
        outputView.printInputRestartOptionGuide();
        String restartOption = readRestartOption();
        return Validator.isNeedRestart(restartOption);
    }

    private String readRestartOption() {
        for (int tryCnt = 1; tryCnt <= 2; tryCnt++) {
            try {
                return inputView.readRestartOption();
            } catch (IllegalArgumentException e) {
                callRetryGuide(tryCnt, 2, e);
            }
        }
        throw new IllegalArgumentException("[ERROR] 입력 시도 횟수 초과");
    }

    private void callRetryGuide(int tryCnt, int maxTry, IllegalArgumentException e) {
        outputView.printErrorMessage(e);
        if (tryCnt != maxTry) {
            outputView.printRetryGuide(tryCnt, maxTry);
        }
    }

    private void restartRoundStart() {
        bridgeGame.retry();
        newRoundStart();
    }
}
