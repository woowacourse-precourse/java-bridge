package bridge;

import bridge.exception.GameExceptionHandler;
import bridge.input.getter.BridgeSizeGetter;
import bridge.input.getter.GameCommandGetter;
import bridge.input.getter.MoveGetter;

import java.util.List;

public class BridgeGame {
    private static BridgeGame bridgeGame;

    private final BridgeGameStarter bridgeGameStarter;
    private final BridgeSizeGetter bridgeSizeGetter;
    private final BridgeMaker bridgeMaker;
    private final MoveGetter moveGetter;
    private final GameCommandGetter gameCommandGetter;
    private final GameExceptionHandler exceptionHandler;

    private BridgeGame() {
        this.bridgeGameStarter = new BridgeGameStarter();
        this.bridgeSizeGetter = BridgeSizeGetter.getBridgeSizeGetter();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.moveGetter = MoveGetter.getMoveGetter();
        this.gameCommandGetter = GameCommandGetter.getGameCommandGetter();
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
        List<String> bridge = this.bridgeMaker.makeBridge(bridgeSize());
        System.out.println();
    }

    public int bridgeSize() {
        int bridgeSize;
        try {
            bridgeSize = this.bridgeSizeGetter.getBridgeSizeFromConsole();
        } catch (IllegalArgumentException exception) {
            this.exceptionHandler.handleIllegalArgumentException(exception);
            bridgeSize = bridgeSize();
        }
        return bridgeSize;
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

    public String retry() {
        String gameCommand;
        try {
            gameCommand = this.gameCommandGetter.getGameCommandFromConsole();
        } catch (IllegalArgumentException exception) {
            this.exceptionHandler.handleIllegalArgumentException(exception);
            gameCommand = retry();
        }
        return gameCommand;
    }

    public boolean isUserMoveCorrect(String correctMove, String userMove) {
        return correctMove.equals(userMove);
    }

}
