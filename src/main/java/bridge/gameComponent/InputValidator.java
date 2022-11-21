package bridge.gameComponent;

public interface InputValidator {
    void validateBridgeSize(int size);
    void validateMove(String move);
    void validateRetry(String retryQuit);
}
