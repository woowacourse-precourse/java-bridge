package bridge;

import bridge.exception.GameExceptionHandler;
import bridge.input.getter.BridgeSizeGetter;
import bridge.input.getter.MoveGetter;

import java.util.List;

public class BridgeGame {
    private static BridgeGame bridgeGame;

    private final BridgeGameStarter bridgeGameStarter;
    private final BridgeSizeGetter bridgeSizeGetter;
    private final BridgeMaker bridgeMaker;
    private final MoveGetter moveGetter;
    private final GameExceptionHandler exceptionHandler;

    private BridgeGame() {
        this.bridgeGameStarter = new BridgeGameStarter();
        this.bridgeSizeGetter = BridgeSizeGetter.getBridgeSizeGetter();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.moveGetter = MoveGetter.getMoveGetter();
        this.exceptionHandler = GameExceptionHandler.getGameExceptionHandler();
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

    public String move() {
        String move;
        try {
            move = this.moveGetter.getMoveFromConsole();
        } catch (IllegalArgumentException exception) {
            this.exceptionHandler.handleIllegalArgumentException(exception);
            move = move();
        }
        return move;
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
