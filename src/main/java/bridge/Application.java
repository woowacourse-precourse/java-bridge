package bridge;

import bridge.constant.BridgeGameStstus;
import bridge.constant.BridgeRetryCommand;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        try {
            BridgeGame bridgeGame = initGame(inputView, outputView);
            gameLoop(inputView, outputView, bridgeGame);
            outputView.printResult(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static BridgeGame initGame(InputView inputView, OutputView outputView) {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
        return bridgeGame;
    }

    public static void gameLoop(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        while (true) {
            moveLoop(inputView, outputView, bridgeGame);
            if (isRetry(inputView, outputView, bridgeGame)) {
                bridgeGame.retry();
                continue;
            }
            break;
        }
    }

    private static void moveLoop(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        while (bridgeGame.getStatus() == BridgeGameStstus.PROCEEDING) {
            String cmd = inputView.readMoving();
            bridgeGame.move(cmd);
            outputView.printMap(bridgeGame);
        }
    }

    private static boolean isRetry(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        if (bridgeGame.getStatus() == BridgeGameStstus.FAIL) {
            String cmd = inputView.readGameCommand();
            if (cmd.equals(BridgeRetryCommand.RETRY.command)) {
                return true;
            }
        }
        return false;
    }
}
