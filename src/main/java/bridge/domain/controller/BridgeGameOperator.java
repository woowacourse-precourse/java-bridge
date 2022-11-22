package bridge.domain.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constants.Direction;
import bridge.constants.GameResult;
import bridge.constants.MovingPossibility;
import bridge.domain.model.Bridge;
import bridge.domain.model.GameResultInformation;
import bridge.domain.view.InputView;
import bridge.domain.view.OutputView;
import bridge.exception.GameOperatorExceptionHandler;
import java.util.List;

public class BridgeGameOperator {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    public BridgeGameOperator() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void playBridgeGame() {
        printStartGuideAndSetBridge();

        playGame();

        printFinalResult();
    }

    private void printStartGuideAndSetBridge() {
        outputView.printStartGuide();

        setBridge();
    }

    private void setBridge() {
        int bridgeSize = getBridgeSize();
        outputView.printEmptyLine();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Bridge.setBridge(bridge);
    }

    private int getBridgeSize() {
        while (true) {
            try {
                outputView.printInputBridgeLengthGuide();
                return getBridgeSizeWithHandlingException();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBridgeSizeWithHandlingException() {
        int bridgeSize = inputView.readBridgeSize();
        GameOperatorExceptionHandler.handleBridgeSizeOutOfRangeException(bridgeSize);
        return bridgeSize;
    }

    private void playGame() {
        boolean gameStart = true;
        while (gameStart) {
            if (tryOneGame() == GameResult.SUCCESS) {
                break;
            }

            gameStart = selectRetryOrNot();
        }
    }

    private GameResult tryOneGame() {
        MovingPossibility MOVING_POSSIBILITY = MovingPossibility.CAN_MOVE;
        int space = 0;

        while (MOVING_POSSIBILITY == MovingPossibility.CAN_MOVE && space < Bridge.getBridgeSize()) {
            MOVING_POSSIBILITY = moveOnce(space);
            outputView.printMap();
            space++;
        }
        return setAndReturnGameResult(MOVING_POSSIBILITY);
    }

    private MovingPossibility moveOnce(int space) {
        Direction MOVE_TO = getDirection();

        return bridgeGame.move(space, MOVE_TO);
    }

    private Direction getDirection() {
        String moveTo = getDirectionInput();

        if (moveTo.equals(Direction.UP.getDirection())) {
            return Direction.UP;
        }
        return Direction.DOWN;
    }

    private String getDirectionInput() {
        while (true) {
            try {
                outputView.printInputMoveDirectionGuide();
                return getDirectionWithExceptionHandling();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getDirectionWithExceptionHandling() {
        String moveTo = inputView.readMoving();

        GameOperatorExceptionHandler.handleNotUOrDException(moveTo);

        return moveTo;
    }

    private GameResult setAndReturnGameResult(MovingPossibility MOVING_POSSIBILITY) {
        GameResult GAME_RESULT = returnGameResult(MOVING_POSSIBILITY);

        setGameResult(GAME_RESULT);

        return GAME_RESULT;
    }

    private GameResult returnGameResult(MovingPossibility MOVING_POSSIBILITY) {
        if (MOVING_POSSIBILITY == MovingPossibility.CAN_MOVE) {
            return GameResult.SUCCESS;
        }
        return GameResult.FAIL;
    }

    private void setGameResult(GameResult GAME_RESULT) {
        GameResultInformation.setGameResult(GAME_RESULT);
    }

    private boolean selectRetryOrNot() {
        final String RESTART = "R";

        String retryInput = getRetryInput();

        if (retryInput.equals(RESTART)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private String getRetryInput() {
        while (true) {
            try {
                outputView.printRetryGuide();
                return getRetryWithExceptionHandling();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getRetryWithExceptionHandling() {
        String retryInput = inputView.readGameCommand();

        GameOperatorExceptionHandler.handleNotROrQException(retryInput);

        return retryInput;
    }

    private void printFinalResult() {
        outputView.printResult();
    }
}
