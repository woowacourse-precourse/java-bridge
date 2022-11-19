package bridge;

public class BridgeLengthValidator {
    private static final int BRIDGE_LENGTH_LOWER_BOUND_INCLUSIVE = 3;
    private static final int BRIDGE_LENGTH_UPPER_BOUND_INCLUSIVE = 20;

    private boolean hasNoIllegalCharacter(String bridgeLengthInput) {
        assert (bridgeLengthInput != null);

        try {
            Integer.parseInt(bridgeLengthInput);
        } catch (NumberFormatException | NullPointerException exception) {
            return false;
        }
        return true;
    }

    private boolean isValidNumberFormat(String bridgeLengthInput) {
        assert (hasNoIllegalCharacter(bridgeLengthInput));

        char firstLetter = bridgeLengthInput.charAt(0);

        if (bridgeLengthInput.length() == 1 && firstLetter == '0') {
            return true;
        }
        return firstLetter >= '1' && firstLetter <= '9';
    }

    private boolean isWithinValidRange(int bridgeLength) {
        return bridgeLength >= BRIDGE_LENGTH_LOWER_BOUND_INCLUSIVE
                && bridgeLength <= BRIDGE_LENGTH_UPPER_BOUND_INCLUSIVE;
    }
}
