package bridge;

import java.util.List;

public class BridgeGame {
    private static BridgeGame bridgeGame;

    private final BridgeGameStarter bridgeGameStarter;
    private final BridgeSizeGetter bridgeSizeGetter;
    private final BridgeMaker bridgeMaker;
    private final GameExceptionHandler exceptionHandler;

    private BridgeGame() {
        this.bridgeGameStarter = new BridgeGameStarter();
        this.bridgeSizeGetter = new BridgeSizeGetter();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.exceptionHandler = new GameExceptionHandler();
    }

    public static BridgeGame getBridgeGame() {
        if (bridgeGame == null) {
            bridgeGame = new BridgeGame();
        }
        return bridgeGame;
    }

    public void runGame() {
        this.bridgeGameStarter.atGameStart();
        System.out.println();
        List<String> bridge = this.bridgeMaker.makeBridge(getBridgeSize());
        System.out.println();
    }

    public void move() {
    }

    public void retry() {
    }

    public int getBridgeSize() {
        int bridgeSize;

        try {
            bridgeSize = this.bridgeSizeGetter.getBridgeSizeFromConsole();
        } catch (IllegalArgumentException exception) {
            this.exceptionHandler.handleIllegalArgumentException(exception);
            bridgeSize = getBridgeSize();
        }

        return bridgeSize;
    }
}
