package bridge.input;

import java.util.List;

public interface BridgeValidator {
    void validateBridgeSize(String size);
    void validateMoveCommand(String command);
    void validateGameCommand(String command);
    void validateBridge(List<String> bridge);
}
