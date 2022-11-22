package bridge.utils.value;

import static bridge.utils.message.ErrorMessagesUtil.RETRY_COMMAND;

public enum GameCommand {
    PLAY("R"),
    FINISH("Q");

    private String command;

    GameCommand(String command) {
        this.command = command;
    }

    public boolean isFinish() {
        if (this == FINISH) {
            return true;
        }
        return false;
    }

    public boolean isPlay() {
        if (this == PLAY) {
            return true;
        }
        return false;
    }

    public static void validateCommand(String command) {
        if (command.equals(PLAY.command) || command.equals(FINISH.command)) {
            return;
        }
        throw new IllegalArgumentException(RETRY_COMMAND.getMessage());
    }

    public static GameCommand getGameCommand(String command) {
        if (command.equals(PLAY.command)) {
            return PLAY;
        }
        return FINISH;
    }
}
