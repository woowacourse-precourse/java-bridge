package bridge.controller;

import bridge.domain.Movement;
import bridge.util.MessageUtil;
import bridge.util.ParserUtil;
import bridge.view.InputView;

public class InputController {

    public int getBridgeSizeInput() {
        MessageUtil.gameStartMsg();
        while (true) {
            try {
                return readAndParseBridgeSizeInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readAndParseBridgeSizeInput() {
        MessageUtil.bridgeSizeInputMsg();
        String bridgeSizeInput = InputView.readBridgeSize();
        ParserUtil.parseBridgeSize(bridgeSizeInput);
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        return bridgeSize;
    }

    public Movement getDirectionInput() {
        while (true) {
            try {
                return readAndParseMovementInput();
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    private Movement readAndParseMovementInput() {
        MessageUtil.movementInputMsg();
        String directionInput = InputView.readMoving();
        ParserUtil.parseMovement(directionInput);
        Movement movement = Movement.getMovementByDirection(directionInput);
        return movement;
    }

    public boolean retryCommandInput() {
        while (true) {
            try {
                return readAndParseGameCommandInput();
            } catch (IllegalArgumentException e3) {
                System.out.println(e3.getMessage());
            }
        }
    }

    private boolean readAndParseGameCommandInput() {
        MessageUtil.retryCommandMsg();
        String retryCommandInput = InputView.readGameCommand();
        ParserUtil.parseGameCommand(retryCommandInput);
        if (retryCommandInput.equals("R")) {
            return true;
        }
        return false;
    }
}
