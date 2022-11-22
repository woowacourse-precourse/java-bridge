package bridge;

import bridge.constant.Move;
import bridge.data.MoveResult;
import bridge.exception.GameExceptionHandler;
import bridge.input.getter.BridgeSizeGetter;
import bridge.input.getter.GameCommandGetter;
import bridge.input.getter.MoveGetter;
import bridge.output.ResultDemonstrator;

import java.util.List;

public class BridgeGame {
    private static BridgeGame bridgeGame;

    private final BridgeGameStarter bridgeGameStarter;
    private final BridgeSizeGetter bridgeSizeGetter;
    private final BridgeMaker bridgeMaker;
    private final MoveGetter moveGetter;
    private final GameCommandGetter gameCommandGetter;
    private final ResultDemonstrator resultDemonstrator;
    private final GameExceptionHandler exceptionHandler;

    private BridgeGame() {
        this.bridgeGameStarter = new BridgeGameStarter();
        this.bridgeSizeGetter = BridgeSizeGetter.getBridgeSizeGetter();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.moveGetter = MoveGetter.getMoveGetter();
        this.gameCommandGetter = GameCommandGetter.getGameCommandGetter();
        this.resultDemonstrator = ResultDemonstrator.getResultDemonstrator();
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

    public int runAttempt(List<String> bridge, List<MoveResult> moveResults) {
        int count = -1;
        boolean isCorrectMove = true;
        while (isCorrectMove && ++count < bridge.size()) {
            String correctMove = bridge.get(count);
            isCorrectMove = isUserMoveCorrect(correctMove, move());
            updateMoveResults(moveResults, correctMove, isCorrectMove);
            resultDemonstrator.printCurrentResult(moveResults);
        }

        return count;
    }

    public boolean isUserMoveCorrect(String correctMove, String userMove) {
        return correctMove.equals(userMove);
    }

    public void updateMoveResults(List<MoveResult> moveResults, String correctMove, boolean isCorrect) {
        if (correctMove.equals(Move.UP.getValue())) {
            moveResults.add(new MoveResult(Move.UP, isCorrect));
            return;
        }
        moveResults.add(new MoveResult(Move.DOWN, isCorrect));
    }
}
