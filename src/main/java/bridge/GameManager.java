package bridge;

import bridge.config.Config;
import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.game.BridgeGame;
import bridge.game.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameManager {

    private final BridgeGame bridgeGame;

    private GameManager(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public static void execute() {
        OutputView.startGame();
        Config config = new Config();
        List<String> bridge = buildBridge(config.bridgeNumberGenerator());
        GameManager gameManager = new GameManager(new BridgeGame(bridge, new GameStatus()));
        gameManager.startGame();
    }

    private static List<String> buildBridge(BridgeNumberGenerator bridgeNumberGenerator) {
        OutputView.getBridgeLength();
        int bridgeSize = InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void startGame() {
        while (true) {
            GameCommand gameCommand = play(bridgeGame);
            if (gameCommand.isFinish()) {
                break;
            }
            if (gameCommand.isRetry()) {
                bridgeGame.retry();
            }
        }
    }

    private GameCommand play(BridgeGame bridgeGame) {
        try {
            OutputView.selectRoom();
            Direction direction = InputView.readMoving();
            bridgeGame.move(direction);
            OutputView.printMap(bridgeGame.getMap());
            if (bridgeGame.isFinish()) {
                OutputView.printResult(bridgeGame.getStatus(), direction);
                return GameCommand.FINISH;
            }
        } catch (IllegalArgumentException e) {
            return getUserDecision();
        }

        return GameCommand.PROGRESS;
    }

    private GameCommand getUserDecision() {
        OutputView.checkRestart();
        String input = InputView.readGameCommand();
        GameCommand.checkStatus(input);

        return GameCommand.getStatus(input);
    }

}
