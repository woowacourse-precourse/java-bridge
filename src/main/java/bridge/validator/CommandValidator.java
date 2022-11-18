package bridge.validator;

public interface CommandValidator {
    boolean isCorrectCommand(String target);

    String getValidCommand(String target);
}
