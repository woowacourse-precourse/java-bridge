package bridge;

import bridge.constant.GameCommand;
import bridge.constant.GameResult;
import bridge.constant.Move;
import bridge.data.FinalResult;
import bridge.data.MoveResult;
import bridge.exception.GameExceptionHandler;
import bridge.input.getter.BridgeSizeGetter;
import bridge.input.getter.GameCommandGetter;
import bridge.input.getter.MoveGetter;
import bridge.output.BridgeGameStarter;
import bridge.output.ResultDemonstrator;

import java.util.ArrayList;
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

        FinalResult finalResult = runGameWithBridge(bridge, new ArrayList<>(), 1);

        this.resultDemonstrator.printFinalResult(finalResult);
    }

    public int bridgeSize() {
        int bridgeSize;
        try {
            bridgeSize = this.bridgeSizeGetter.getBridgeSizeFromConsole();
        } catch (IllegalArgumentException exception) {
            this.exceptionHandler.handleIllegalArgumentException(exception);
            bridgeSize = bridgeSize();
            this.exceptionHandler.initializeExceptionOccurrenceCount();
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
            this.exceptionHandler.initializeExceptionOccurrenceCount();
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
            this.exceptionHandler.initializeExceptionOccurrenceCount();
        }
        return gameCommand;
    }

    public FinalResult runGameWithBridge(List<String> bridge, List<MoveResult> moveResults, int numAttempts) {
        int numCorrectMoves = runAttempt(bridge, moveResults);

        GameResult gameResult = getFinalResultOrNull(numCorrectMoves, bridge);

        if (gameResult == null) {
            moveResults.clear();
            return runGameWithBridge(bridge, moveResults, numAttempts + 1);
        }

        return new FinalResult(gameResult, numAttempts, moveResults);
    }

    public int runAttempt(List<String> bridge, List<MoveResult> moveResults) {
        int correctMoveCount = -1;
        boolean isCorrectMove = true;
        while (isCorrectMove && ++correctMoveCount < bridge.size()) {
            String correctMove = bridge.get(correctMoveCount);
            isCorrectMove = isUserMoveCorrect(correctMove, move());
            updateMoveResults(moveResults, correctMove, isCorrectMove);
            resultDemonstrator.printCurrentResult(moveResults);
        }

        return correctMoveCount;
    }

    public GameResult getFinalResultOrNull(int correctMoveCount, List<String> bridge) {
        if (correctMoveCount == bridge.size()) {
            return GameResult.SUCCESS;
        }
        if (!retry().equals(GameCommand.RETRY.getValue())) {
            return GameResult.FAILURE;
        }
        return null;
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
