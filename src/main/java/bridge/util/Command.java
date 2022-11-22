package bridge.util;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/17
 */
public enum Command {
    MOVE_LOWER_LETTER("D")
    , MOVE_UPPER_LETTER("U")
    , GAME_RETRY_LETTER("R")
    , GAME_QUIT_LETTER("Q")
    ;
    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
