package bridge.input;

public interface BridgeValidator {
    void validateBridgeSize(String size);
    void validateMoveCommand(String command);
    void validateGameCommand(String command);
}
