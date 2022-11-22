package bridge.gameComponent;

public interface InputValidator {
    void validateBridgeSize(String size);
    void validateMove(String move);
    void validateRetry(String retryQuit);
    String inputTemplate(String validateMethod);
}
