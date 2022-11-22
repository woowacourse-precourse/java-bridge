package bridge;

import java.util.List;


public class BridgeGameController {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    BridgeGame bridgeGame = new BridgeGame();

    public BridgeGame initGame() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.initBridge(bridge);

        return bridgeGame;
    }

    public boolean move() {
        String moving = inputView.readMoving();
        boolean isMovable = bridgeGame.move(moving);
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserRoute());

        return isMovable;
    }


    public void endGame(int count) {
        List<String> bridge = bridgeGame.getBridge();
        List<String> userRoute = bridgeGame.getUserRoute();

        outputView.printResult(bridge, userRoute, count);
    }

    public boolean retry() {
        String gameCommand = inputView.readGameCommand();
        if (wantRetry(gameCommand)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private static boolean wantRetry(String command) {
        if ("R".equals(command)) {
            return true;
        }
        return false;
    }


    public void play() {
        for (int i = 0; i < bridgeGame.getBridge().size(); i++) {
            boolean isMovable = move();
            if (!isMovable && retry()) {
                play();
                break;
            }
        }
    }

    public int getCount() {
        return this.bridgeGame.getGameCount();
    }
}
