package bridge.domain;

public interface InputHandler {
    int getBridgeSize(String rawInput);
    String getMovingCommand(String rawInput);
    String getGameCommand(String rawInput);
    int parseInteger(String rawInput);
    String removeSpacesFromString(String rawInput);
    void validateBridgeLength(int length);
    void validateMoving(String command);
    void validateGameCommand(String command);
}
