package bridge.util;

import bridge.constant.ERROR;
import bridge.constant.GameState;

public class Validate {

    private GameState statement = new GameState();

    public void validateBridgeSize(String size) {
        try {
            int sizeInt = Integer.parseInt(size);
            isSizeInRange(sizeInt);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR.sizeException.getException());
        }
    }

    private void isSizeInRange(int sizeInt) {
        if (!(sizeInt >= statement.MIN_RANGE && sizeInt <= statement.MAX_RANGE)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateMoving(String size) {
        try {
            if (!size.equals(statement.DOWN) && !size.equals(statement.UP)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR.moveException.getException());
        }
    }

    public void validateGameDefinition(String definition) {
        try {
            if (!definition.equals(statement.QUIT) && !definition.equals(statement.RETRY)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR.DEFINITION_EXCEPTION.getException());
        }
    }


}
