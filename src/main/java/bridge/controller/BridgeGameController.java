package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.BridgeSize;
import bridge.domain.vo.GameCommand;
import bridge.domain.vo.Moving;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartBridgeGame();

        BridgeMap bridgeMap = makeBridgeMap(inputBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridgeMap);
        playBridgeGame(bridgeGame);

        outputView.printResult(bridgeGame);
    }

    private void playBridgeGame(BridgeGame bridgeGame) {
        if (!movePlayer(bridgeGame)) {
            bridgeGame.retry(inputGameCommand());
        }
        if (bridgeGame.isEnd()) {
            return;
        }
        playBridgeGame(bridgeGame);
    }

    private boolean movePlayer(BridgeGame bridgeGame) {
        boolean isMove = bridgeGame.move(inputMoving());
        outputView.printMap(bridgeGame);
        return isMove;
    }

    private BridgeSize inputBridgeSize() {
        try {
            return new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputBridgeSize();
    }

    private BridgeMap makeBridgeMap(BridgeSize bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> test = bridgeMaker.makeBridge(bridgeSize.getValue());
        System.out.println(test);
        return new BridgeMap(test);
    }

    private Moving inputMoving() {
        try {
            return new Moving(inputView.readMoving());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputMoving();
    }


    private GameCommand inputGameCommand() {
        try {
            return new GameCommand(inputView.readGameCommand());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputGameCommand();
    }
}
