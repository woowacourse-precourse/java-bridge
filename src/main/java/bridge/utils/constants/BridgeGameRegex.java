package bridge.utils.constants;

public enum BridgeGameRegex {
    BRIDGE_MOVE_INPUT_REGEX("^U{1}$|^D{1}$"),
    GAME_RETRY_COMMAND_REGEX("^R{1}$|^Q{1}$"),
    BRIDGE_SIZE_INPUT_REGEX("^[3-9]{1}$|^1[0-9]{1}$|^20$");

    private final String regex;
    BridgeGameRegex(String regex){
        this.regex = regex;
    }

    public String getRegex(){
        return regex;
    }
}
