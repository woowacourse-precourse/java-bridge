package bridge.input;

public interface BridgeInputValidator {
    boolean validateBridgeSize(String size);
    boolean validateMoveCommand(String command);
    boolean validateGameCommand(String command);
}
