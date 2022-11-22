package bridge.controller;


import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.GameCommand;
import bridge.model.GameResult;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();

    public void run() {
        outputView.printStartMessage();

        List<String> bridge = generateBridge();
        BridgeGame bridgeGame = new BridgeGame(bridge);
        GameResult result = playGames(bridge, bridgeGame);

        outputView.printResult(result, bridge, bridgeGame.getTryNumber());
    }

    private List<String> generateBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private GameResult playGames(List<String> bridge, BridgeGame bridgeGame) {
        GameResult result = new GameResult();
        boolean gameEnd = false;
        while (!gameEnd) {
            result = playGame(bridge, bridgeGame, result);
            gameEnd = isGameEnd(result);
            resetGame(bridgeGame, gameEnd);
        }
        return result;
    }

    private GameResult playGame(List<String> bridge, BridgeGame bridgeGame, GameResult result) {
        for (int round = 0; round < bridge.size(); round++) {
            result = bridgeGame.move(round, inputView.readMoving());
            outputView.printMap(bridge, result.getGameResult());
            if (result.isGameOver()) {
                break;
            }
        }
        return result;
    }

    private boolean isGameEnd(GameResult result) {
        if (result.isGameOver()) {
            return GameCommand.QUIT.isSame(inputView.readGameCommand());
        }
        return true;
    }

    private void resetGame(BridgeGame bridgeGame, boolean gameEnd) {
        if (!gameEnd) {
            bridgeGame.retry();
        }
    }
}
