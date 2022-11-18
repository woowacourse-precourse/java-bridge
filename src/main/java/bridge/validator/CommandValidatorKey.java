package bridge.validator;

public enum CommandValidatorKey {
    MOVING_COMMAND_VALIDATOR("[U|D]"),
    RETRY_COMMAND_VALIDATOR("[Q|R]");
    
    private final String commandForm;
    
    CommandValidatorKey(final String commandForm) {
        this.commandForm = commandForm;
    }
    
    public boolean isMovingCommandValidatorKey() {
        return this == MOVING_COMMAND_VALIDATOR;
    }
    
    public String getCommandForm() {
        return commandForm;
    }
}
