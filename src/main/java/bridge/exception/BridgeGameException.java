package bridge.exception;

public class BridgeGameException {
    public void inputContainCharException(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkNumberRangeException(String number) {
        String REGEX = "^[3-9]{1}$|^1{1}[0-9]{1}$|^2{1}0{1}$";
        if (!number.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public void checkInputSizeException(String str) {
        if (str.length() != 1) {
            throw new IllegalArgumentException();
        }
    }

    public void checkCorrectUpOrDownException(String str) {
        if (!str.equals("U") && !str.equals("D")) {
            throw new IllegalArgumentException();
        }
    }

    public void checkRestartOrDoneException(String str) {
        if (!str.equals("R") && !str.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }
}
