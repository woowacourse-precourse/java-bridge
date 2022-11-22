package bridge;

import util.InputView;
import util.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = newBridgeGame();
    }

    private BridgeGame newBridgeGame() {
        outputView.printStartGame();
        int bridgeSize = inputReadBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return new BridgeGame(bridge);
    }

    private int inputReadBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void run() {
        while (bridgeGame.isGameOngoing()) {
            moveBridge();
            if (bridgeGame.isFail()) {
                String userCommand = inputReadGameCommand();
                bridgeGame.retry(userCommand);
            }
        }
        outputView.printResult(bridgeGame);
    }

    private void moveBridge() {
        String readMoving = inputReadMoving();
        BridgeMap bridgeMap = bridgeGame.move(readMoving);
        outputView.printMap(bridgeMap);
    }

    private String inputReadMoving() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String inputReadGameCommand() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
