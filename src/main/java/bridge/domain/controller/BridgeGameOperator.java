package bridge.domain.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constants.MovingDirection;
import bridge.constants.MovingPossibility;
import bridge.domain.model.Bridge;
import bridge.domain.view.InputView;
import bridge.domain.view.OutputView;
import java.util.List;

public class BridgeGameOperator {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public BridgeGameOperator() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void playBridgeGame() {
        final String UP = "U";
        final String DOWN = "D";
        final String RESTART = "R";
        final String QUIT = "Q";

        outputView.printStartGuide();

        outputView.printInputBridgeLengthGuide();

        int bridgeSize = inputView.readBridgeSize();

        outputView.printEmptyLine();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        Bridge.setBridge(bridge);

        MovingPossibility MOVING_POSSIBILITY = MovingPossibility.CAN_MOVE;
//        String retryInput = RESTART;
//        while (retryInput.equals(RESTART)) {
        int space = 0;

        while (MOVING_POSSIBILITY == MovingPossibility.CAN_MOVE) {
            outputView.printInputMoveDirectionGuide();

            String moveTo = inputView.readMoving();

            MovingDirection MOVE_TO = MovingDirection.UP;

            if (moveTo.equals(DOWN)) {
                MOVE_TO = MovingDirection.DOWN;
            }

            MOVING_POSSIBILITY = bridgeGame.move(space, MOVE_TO);

            outputView.printMap();
            space++;
        }

//        }

    }
}
