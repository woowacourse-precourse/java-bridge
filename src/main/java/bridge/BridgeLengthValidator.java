package bridge;

public class BridgeLengthValidator {

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
}
