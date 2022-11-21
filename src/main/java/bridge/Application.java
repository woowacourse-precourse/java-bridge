package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeSize;
import bridge.model.Direction;
import bridge.model.GameCommand;
import bridge.model.GameMap;
import bridge.model.MoveResult;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.printGameStart();

        BridgeGame bridgeGame = new BridgeGame(createBridge(), new Player());
        GameMap gameMap = new GameMap();
        while (!bridgeGame.quit()) {
            playGame(bridgeGame, gameMap);
        }
        GameResult gameResult = bridgeGame.gameResult();
        outputView.printResult(gameResult, gameMap);
    }

    private static void playGame(BridgeGame bridgeGame, GameMap gameMap) {
        MoveResult moveResult = bridgeGame.move(inputDirection());
        gameMap.draw(moveResult);
        outputView.printMap(gameMap);
        if (bridgeGame.end()) {
            bridgeGame.retry(inputGameCommand(), gameMap);
        }
    }

    private static BridgeSize inputBridgeSize() {
        try {
            String size = inputView.readBridgeSize();
            return new BridgeSize(size);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputBridgeSize();
        }
    }

    private static Bridge createBridge() {
        BridgeSize bridgeSize = inputBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(bridgeSize.getSize()));
    }

    private static Direction inputDirection() {
        try {
            return Direction.fromInput(inputView.readDirection());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputDirection();
        }
    }

    private static GameCommand inputGameCommand() {
        try {
            return GameCommand.fromInput(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputGameCommand();
        }
    }
}
