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
}
