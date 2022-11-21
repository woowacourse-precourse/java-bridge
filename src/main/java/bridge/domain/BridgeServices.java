package bridge.domain;

import bridge.view.InputView;
import bridge.constant.Bridge.GameConstants;

public class BridgeServices {

    private final BridgeChecker bridgeChecker;

    public BridgeServices() {
        bridgeChecker = BridgeChecker.getInstance();
    }

    public boolean retry() {
        try {
            String retryOrNot = InputView.readGameCommand();
            bridgeChecker.validateGameCommand(retryOrNot);
            return retryOrNot.equals(GameConstants.GAME_RETRY);
        } catch (IllegalArgumentException e) {
            return handlingGameCommandException(e);
        }
    }

    public String decideDirection() {
        try {
            String direction = InputView.readMoving();
            bridgeChecker.validateMoving(direction);
            return direction;
        } catch (IllegalArgumentException e) {
            return handlingMovingException(e);
        }
    }

    public int takeSize() { //
        try {
            String bridgeSize = InputView.readBridgeSize();
            bridgeChecker.validateBridgeSize(bridgeSize);
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            return handlingBridgeSizeException(e);
        }
    }

    private String handlingMovingException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return decideDirection();
    }

    private boolean handlingGameCommandException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return retry();
    }

    private int handlingBridgeSizeException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return takeSize();
    }
}
