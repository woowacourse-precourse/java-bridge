package bridge.utils.constants;

public enum BridgeGameRegex {
    BRIDGE_MOVE_INPUT_REGEX("^"+GameCommand.GO_UP.getCommand()+"{1}$|^" +GameCommand.GO_DOWN.getCommand()+"{1}$"),
    GAME_RETRY_COMMAND_REGEX("^"+GameCommand.RETRY.getCommand()+"{1}$|^"+GameCommand.QUIT.getCommand()+"{1}$"),
    BRIDGE_SIZE_INPUT_REGEX("^[3-9]{1}$|^1[0-9]{1}$|^20$");

    private final String regex;
    BridgeGameRegex(String regex){
        this.regex = regex;
    }

    public String getRegex(){
        return regex;
    }
}
