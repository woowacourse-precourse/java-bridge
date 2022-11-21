package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private InputView inputView;
    private OutputView outputView;

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        BridgeGame bridgeGame = constructBridge(); // 게임 끝까지 사용
        while (!bridgeGame.gameOver()){
            movePlayer(bridgeGame);
            printResult(bridgeGame);
            isRestart(bridgeGame);
        }
        outputView.printResult(bridgeGame);
    }

    private BridgeGame constructBridge() {
        int bridgeSize = inputView.readBridgeSize();
        return new BridgeGame(bridgeSize);
    }

    private void movePlayer(BridgeGame bridgeGame) {
        String playerMoving = inputView.readMoving();
        bridgeGame.move(playerMoving);
    }

    private void printResult(BridgeGame bridgeGame){
        outputView.printMap(bridgeGame);
    }

    private void isRestart(BridgeGame bridgeGame) {
        if (bridgeGame.gameOver()) {
            String gameCommand = inputView.readGameCommand();
            bridgeGame.retry(gameCommand);
        }
    }
}
