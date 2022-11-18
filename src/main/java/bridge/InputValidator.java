package bridge;

public class InputValidator {

    public void checkBridgeInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(BridgeConstant.INPUT_TYPE_EXCEPTION.getValue());
        }
        if(!isInBoundary(input)) {
            throw new IllegalArgumentException(BridgeConstant.INPUT_BOUNDARY_EXCEPTION.getValue());
        }
    }

    public boolean isInteger(String input) {
        return input.matches("[0-9]+");
    }

    public boolean isInBoundary(String input) {
        return (Integer.parseInt(input) >= 3 && Integer.parseInt(input) <= 20);
    }

    public void checkMovement(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(BridgeConstant.MOVEMENT_EXCEPTION.getValue());
        }
    }

}
