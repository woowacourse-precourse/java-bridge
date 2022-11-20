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
            printStartGame();

            int bridgeSize = inputBridgeSize();
            BridgeGame bridgeGame = createNewGame(bridgeSize);

            while (true) {
                String moving = inputMoving();
                bridgeGame.move(moving);
                printMovingMap(bridgeGame);

                if (!bridgeGame.canContinue()) {
                    if (!bridgeGame.isLatestMovingSuccess()) {
                        String gameCommand = inputGameCommand();

                        if ("R".equals(gameCommand)) {
                            bridgeGame.retry();
                            continue;
                        }
                    }

                    break;
                }
            }

            printResult(bridgeGame);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private void printResult(BridgeGame bridgeGame) {
        MovingMap movingMap = bridgeGame.getMovingMap();
        boolean isClear = bridgeGame.isClear();
        int tryCount = bridgeGame.getTryCount();
        outputView.printResult(movingMap, isClear, tryCount);
    }

    private String inputGameCommand() {
        outputView.printEnterGameCommand();
        return inputView.readGameCommand();
    }

    private void printMovingMap(BridgeGame bridgeGame) {
        MovingMap movingMap = bridgeGame.getMovingMap();
        outputView.printMap(movingMap);
        outputView.println();
    }

    private String inputMoving() {
        outputView.printEnterMoving();
        return inputView.readMoving();
    }

    private int inputBridgeSize() {
        outputView.printEnterBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        outputView.println();
        return bridgeSize;
    }

    private void printStartGame() {
        outputView.printStartGame();
        outputView.println();
    }

    private BridgeGame createNewGame(int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Player player = new Player();

        return new BridgeGame(bridge, player);
    }
}
