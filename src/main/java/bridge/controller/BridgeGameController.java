package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.BridgeSize;
import bridge.domain.vo.GameCommand;
import bridge.domain.vo.Moving;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static BridgeGameController of(InputView inputView, OutputView outputView) {
        return new BridgeGameController(inputView, outputView);
    }

    public void run() {
        outputView.printStartBridgeGame();

        BridgeMap bridgeMap = makeBridgeMap(inputBridgeSize());
        BridgeGame bridgeGame = BridgeGame.from(bridgeMap);
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
            return BridgeSize.from(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputBridgeSize();
    }

    private BridgeMap makeBridgeMap(BridgeSize bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        return BridgeMap.from(bridgeMaker.makeBridge(bridgeSize.getValue()));
    }

    private Moving inputMoving() {
        try {
            return Moving.from(inputView.readMoving());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputMoving();
    }


    private GameCommand inputGameCommand() {
        try {
            return GameCommand.from(inputView.readGameCommand());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputGameCommand();
    }
}
