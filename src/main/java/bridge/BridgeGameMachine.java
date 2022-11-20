package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.MovingMap;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameMachine {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            outputView.printStartGame();
            outputView.println();

            outputView.printEnterBridgeSize();
            int bridgeSize = inputView.readBridgeSize();
            outputView.println();

            BridgeGame bridgeGame = createNewGame(bridgeSize);

            while (true) {
                outputView.printEnterMoving();
                String moving = inputView.readMoving();
                bridgeGame.move(moving);

                MovingMap movingMap = bridgeGame.getMovingMap();
                outputView.printMap(movingMap);
                outputView.println();

                if (!bridgeGame.canContinue()) {
                    if (!bridgeGame.isLatestMovingSuccess()) {
                        outputView.printEnterGameCommand();
                        String gameCommand = inputView.readGameCommand();

                        if ("R".equals(gameCommand)) {
                            bridgeGame.retry();
                            continue;
                        }
                    }

                    break;
                }
            }

            MovingMap movingMap = bridgeGame.getMovingMap();
            boolean isClear = bridgeGame.isClear();
            int tryCount = bridgeGame.getTryCount();
            outputView.printResult(movingMap, isClear, tryCount);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private BridgeGame createNewGame(int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Player player = new Player();

        return new BridgeGame(bridge, player);
    }
}
