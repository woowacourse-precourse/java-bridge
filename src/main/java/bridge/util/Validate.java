package bridge.util;

import bridge.constant.ERROR;
import bridge.constant.GameState;

public class Validate {


    public void validateBridgeSize(String size) {
        try {
            int sizeInt = Integer.parseInt(size);
            isSizeInRange(sizeInt);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR.SIZE_Exception.getException());
        }
    }

    private void isSizeInRange(int sizeInt) {
        if (isWrongSize(sizeInt)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isWrongSize(int sizeInt) {
        return !(sizeInt >= GameState.MIN_RANGE && sizeInt <= GameState.MAX_RANGE);
    }

    public void validateMoving(String move) {
        try {
            if (isWrongMove(move)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR.MOVE_Exception.getException());
        }
    }

    private static boolean isWrongMove(String move) {
        return !move.equals(GameState.DOWN) && !move.equals(GameState.UP);
    }

    public void validateGameDefinition(String definition) {
        try {
            if (isWrongDefinition(definition)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR.DEFINITION_EXCEPTION.getException());
        }
    }

    private static boolean isWrongDefinition(String definition) {
        return !definition.equals(GameState.QUIT) && !definition.equals(GameState.RETRY);
    }

    public String validateFinalSuccess(Boolean isSuccess) {
        String gameResult = GameState.GAME_FAIL;
        if (isSuccess) {
            gameResult = GameState.GAME_SUCCESS;
        }
        return gameResult;
    }


}
