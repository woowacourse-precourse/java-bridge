package bridge;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Restart {
    public static final String RESTART_GAME_PHRASE = "R";
    public static final String END_GAME_PHRASE = "Q";
    private static final String RESTART_EXCEPTION_MESSAGE = "[ERROR] 재시작은 R, 종료는 Q로 입력해야 합니다.";
    private final String command;

    public Restart(String command) {
        if ((!Objects.equals(command, RESTART_GAME_PHRASE))
                && (!Objects.equals(command, END_GAME_PHRASE))) {
            throw new NoSuchElementException(RESTART_EXCEPTION_MESSAGE);
        }
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
