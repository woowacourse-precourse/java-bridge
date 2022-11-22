package bridge.exception;

public class BridgeGameException {
    public void inputContainCharException(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }
}
