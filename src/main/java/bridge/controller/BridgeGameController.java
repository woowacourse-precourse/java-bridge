package bridge.controller;

import bridge.*;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void startGame() {
        System.out.println(GAME_START_MESSAGE);
        int bridgeSize = inputView.readBridgeSize();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        do {
            playGame(bridge);
        } while (!bridgeGame.isGameClear() && !bridgeGame.isQuitGame());
        outputView.printResult(bridgeGame);
    }

    public void playGame(List<String> bridge) {
        for (int index = 0; index < bridge.size(); index++) {
            boolean canMove = bridgeGame.move(bridge, index, inputView.readMoving());
            outputView.printMap(bridgeGame.getUpBridge(), bridgeGame.getDownBridge());
            if (!canMove) {
                restartOrPlayGame();
                break;
            }
        }
    }

    public void restartOrPlayGame() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("Q")) {
            bridgeGame.quit();
            return;
        }
        bridgeGame.retry();
    }
}
