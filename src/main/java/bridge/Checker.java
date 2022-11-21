package bridge;

import static constant.Values.Message.*;

import constant.Values.MoveCase;

public class Checker {
    public int checkValidate(String input) throws IllegalArgumentException {
        try {
            return checkNumeric(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(
                    String.format(ERROR_INPUT_VALUE.getMessage(), input) + ERROR_SIZE.getMessage()
                            + ERROR_RE_INPUT.getMessage());
        }
    }

    public int checkNumeric(String input) throws IllegalArgumentException {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException();
        }
        return checkNegative(inputNumber);
    }

    public int checkNegative(int input) throws IllegalArgumentException {
        if (input < 0) {
            throw new IllegalArgumentException();
        }
        return checkBoundary(input);
    }

    public int checkBoundary(int input) throws IllegalArgumentException {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public String checkMoveValidate(String move) {
        if (!(move.equals("U") | move.equals("D"))) {
            throw new IllegalArgumentException(
                    String.format(ERROR_INPUT_VALUE.getMessage(), move) + ERROR_MOVE.getMessage()
                            + ERROR_RE_INPUT.getMessage());
        }
        return move;
    }

    public MoveCase checkMoveSuccess(String value, String move) {
        return MoveCase.findByValueAndMove(value, move);
    }

    public boolean checkBridgeGameResult(BridgeGame bridgeGame) {
        return bridgeGame.getResults().get(bridgeGame.getIndex() - 1).isResult();
    }

    public String checkGameOption(String gameOption) {
        if (!(gameOption.equals("R") | gameOption.equals("Q"))) {
            throw new IllegalArgumentException(
                    String.format(ERROR_INPUT_VALUE.getMessage(), gameOption) + ERROR_RETRY.getMessage()
                            + ERROR_RE_INPUT.getMessage());
        }
        return gameOption;
    }

    public boolean checkRetry(String gameOption) {
        return gameOption.equals("R");
    }

    public boolean checkGameSuccess(BridgeGame bridgeGame) {
        boolean success=false;
        success=bridgeGame.getIndex()==bridgeGame.getBridge().size();
        for(MoveCase result:bridgeGame.getResults()){
            success=success&&result.isResult();
        }
        return success;
    }
}
