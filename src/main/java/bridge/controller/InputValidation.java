package bridge.controller;

public class InputValidation extends InputException {
    public void bridgeSize(String userInput) {
        isNumber(userInput);
        bridgeSize(Integer.valueOf(userInput));
    }

    public void bridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            raiseBridgeSizeValidityException();
        }
    }

    public void userMove(String userInput) {
        if (!userInput.matches("[U|D]")) {
            raiseUserMoveValidityException();
        }
    }

    public void restartOrEnd(String userInput) {
        if (!userInput.matches("[R|Q]")) {
            raiseRetryOrQuitValidityException();
        }
    }

    private void isNumber(String numberable) throws IllegalArgumentException {
        if (!numberable.matches("[0-9]*")) {
            raiseNumberFormatValidityException();
        }
    }
}
