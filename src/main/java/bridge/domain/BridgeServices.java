package bridge.domain;

import bridge.constant.BridgeGameConstants;
import bridge.view.InputView;

public class BridgeServices {

    private final Checker checker;

    public BridgeServices() {
        checker = Checker.getInstance();
    }

    public boolean retry() {
        try {
            String retryOrNot = InputView.readGameCommand();
            checker.validateGameCommand(retryOrNot);
            return retryOrNot.equals(BridgeGameConstants.GAME_RETRY);
        } catch (IllegalArgumentException e) {
            return handlingGameCommandException(e);
        }
    }

    public String decideDirection() {
        try {
            String direction = InputView.readMoving();
            checker.validateMoving(direction);
            return direction;
        } catch (IllegalArgumentException e) {
            return handlingMovingException(e);
        }
    }

    public int takeSize() { //
        try {
            String bridgeSize = InputView.readBridgeSize();
            checker.validateBridgeSize(bridgeSize);
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
