package bridge.domain.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constants.Direction;
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

    public BridgeGameOperator() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void playBridgeGame() {
        final String RESTART = "R";

        GameResultInformation.increaseCountOfTry();
        printStartGuideAndSetBridge();

        String retryInput = RESTART;
        while (retryInput.equals(RESTART)) {
            tryOneGame();

            outputView.printRetryGuide();
            retryInput = inputView.readGameCommand();
            if (retryInput.equals(RESTART)) {
                bridgeGame.retry();
            }
        }
    }

    private void printStartGuideAndSetBridge() {
        outputView.printStartGuide();

        setBridge();
    }

    private void setBridge() {
        outputView.printInputBridgeLengthGuide();
        int bridgeSize = inputView.readBridgeSize();
        outputView.printEmptyLine();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Bridge.setBridge(bridge);
    }

    private void tryOneGame() {
        MovingPossibility MOVING_POSSIBILITY = MovingPossibility.CAN_MOVE;
        int space = 0;

        while (MOVING_POSSIBILITY == MovingPossibility.CAN_MOVE) {
            MOVING_POSSIBILITY = moveOnce(space);

            outputView.printMap();
            space++;
        }
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
}
