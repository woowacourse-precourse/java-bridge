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
import java.util.List;

public class BridgeGameOperator {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private int bridgeSize;

    public BridgeGameOperator() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeSize = 0;
    }

    public void playBridgeGame() {
        GameResultInformation.increaseCountOfTry();
        printStartGuideAndSetBridge();

        boolean gameStart = true;
        while (gameStart) {
            if (tryOneGame() == MovingPossibility.CAN_MOVE) {
                GameResultInformation.setGameResult(GameResult.SUCCESS);
                break;
            }

            if (!selectRetryOrNot()) {
                gameStart = false;
                GameResultInformation.setGameResult(GameResult.FAIL);
            }
        }
    }

    private void printStartGuideAndSetBridge() {
        outputView.printStartGuide();

        setBridge();
    }

    private void setBridge() {
        outputView.printInputBridgeLengthGuide();
        bridgeSize = inputView.readBridgeSize();
        outputView.printEmptyLine();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Bridge.setBridge(bridge);
    }

    private MovingPossibility tryOneGame() {
        MovingPossibility MOVING_POSSIBILITY = MovingPossibility.CAN_MOVE;
        int space = 0;

        while (MOVING_POSSIBILITY == MovingPossibility.CAN_MOVE && space < bridgeSize) {
            MOVING_POSSIBILITY = moveOnce(space);
            outputView.printMap();
            space++;
        }
        return MOVING_POSSIBILITY;
    }

    private MovingPossibility moveOnce(int space) {
        outputView.printInputMoveDirectionGuide();

        Direction MOVE_TO = getDirection();

        return bridgeGame.move(space, MOVE_TO);
    }

    private Direction getDirection() {
        final String UP = "U";
        String moveTo = inputView.readMoving();

        if (moveTo.equals(UP)) {
            return Direction.UP;
        }
        return Direction.DOWN;
    }

    private boolean selectRetryOrNot() {
        outputView.printRetryGuide();

        return isRetrySelected();
    }

    private boolean isRetrySelected() {
        final String RESTART = "R";

        String retryInput = inputView.readGameCommand();
        if (retryInput.equals(RESTART)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}
