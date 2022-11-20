package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.BridgeSize;
import bridge.domain.vo.GameCommand;
import bridge.domain.vo.Moving;
import bridge.domain.vo.PlayerMap;
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
        BridgeSize bridgeSize = inputBridgeSize();
        BridgeMap bridgeMap = makeBridgeMap(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridgeMap);
        PlayerMap playerMap = playBridgeGame(bridgeGame);
        outputView.printResult(playerMap, bridgeGame);
    }

    private PlayerMap playBridgeGame(BridgeGame bridgeGame) {
        PlayerMap playerMap = movePlayer(bridgeGame);
        if (!bridgeGame.isMove()) {
            playerMap = bridgeGame.retry(inputGameCommand());
        }
        if (bridgeGame.isEnd()) {
            return playerMap;
        }
        return playBridgeGame(bridgeGame);
    }

    private PlayerMap movePlayer(BridgeGame bridgeGame) {
        PlayerMap playerMap = bridgeGame.move(inputMoving());
        outputView.printMap(playerMap);
        return playerMap;
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
