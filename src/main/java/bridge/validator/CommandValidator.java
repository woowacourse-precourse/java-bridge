package bridge.validator;

public interface CommandValidator {
    String COMMAND_SEPARATOR = ", ";

    boolean isCorrectCommand(String target);

    String getValidCommand(String target);

    String getCommandsDescription();
}
