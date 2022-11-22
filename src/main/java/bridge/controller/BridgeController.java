package bridge.controller;

import bridge.BridgeGame;
import bridge.domain.BridgeMap;
import bridge.type.BridgeGameCommandType;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startBridgeGame() {
        outputView.printStart();
        outputView.printAskingBridgeSize();
        int bridgeSize = inputView.readBridgeSize();

        bridgeGame.createAndRegisterBridge(bridgeSize);
    }

    public void moveBridge() {
        boolean isFinish = true;
        while (isFinish) {
            outputView.printAskingMovingSide();
            String bridgeSide = inputView.readMoving();
            BridgeMap bridgeMap = bridgeGame.move(bridgeSide);
            outputView.printMap(bridgeMap);
            isFinish = bridgeGame.isFinish(bridgeSide);
        }
    }

    public void finishBridgeGame() {
        outputView.printResult(bridgeGame.getFinishBridgeMap(), bridgeGame.getChallengeResultToString(), bridgeGame.getChallengeCount());
    }

    public boolean retryBridgeGame() {
        outputView.printGameCommand();
        String gameCommand = inputView.readGameCommand();
        BridgeGameCommandType gameCommandType = BridgeGameCommandType.getFindByGameCommand(gameCommand);

        bridgeGame.retry(gameCommandType);

        return gameCommandType.getIsRetry();
    }

    public void executeBridgeGame() {
        startBridgeGame();
        boolean isRetry = true;
        while (isRetry) {
            moveBridge();
            if (bridgeGame.getChallengeResult()) {
                break;
            }
            isRetry = retryBridgeGame();
        }
    }
}
