package bridge.domain;

public interface InputHandler {
    int getBridgeSize(String rawInput);
    String getMovingCommand(String rawInput);
    String getGameCommand(String rawInput);
}
