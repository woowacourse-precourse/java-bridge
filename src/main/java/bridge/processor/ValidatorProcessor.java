package bridge.processor;

public interface ValidatorProcessor {

    Integer validateBridgeSizeInput(String input);

    String validateRetryInput(String input);

    String validateCommandInput(String input);
}
