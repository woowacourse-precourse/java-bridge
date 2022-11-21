package bridge.processor;

public interface ValidatorProcessor {

    Integer validateBridgeSizeInput(String input);

    void validateRetryInput(String input);

    void validateCommandInput(String input);
}
