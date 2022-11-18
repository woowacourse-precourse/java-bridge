package bridge.validator;

public enum CommandValidatorKey {
    MOVING_COMMAND_VALIDATOR("[U|D]", "U 또는 D 만 입력할 수 있습니다."),
    RETRY_COMMAND_VALIDATOR("[Q|R]", "Q 또는 R 만 입력할 수 있습니다.");
    
    private final String commandForm;
    private final String errorMessage;
    
    CommandValidatorKey(final String commandForm, final String errorMessage) {
        this.commandForm = commandForm;
        this.errorMessage = errorMessage;
    }
    
    public String getCommandForm() {
        return commandForm;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
}
