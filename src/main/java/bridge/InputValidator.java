package bridge;

public class InputValidator {

    public void validateInputBridgeSize(String bridgeSize) {
        validateNumber(bridgeSize);
    }

    private void validateNumber(String number) {
        if(number.matches(String.valueOf(Regex.NUMBER))) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_OUT_OF_SIZE.toString());
        }
    }
}
