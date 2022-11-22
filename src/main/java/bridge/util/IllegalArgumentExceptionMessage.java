package bridge.util;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/17
 */
public enum IllegalArgumentExceptionMessage {
    INPUT_BRIDGE_LENGTH("다리 길이는 3부터 20 사이의 값이어야 합니다.")
    ,INPUT_BRIDGE_FORM("다리 길이는 3부터 20 사이의 숫자여야 합니다.")
    ,INPUT_MOVE_COMMAND_FORM("이동할 칸은 " + Command.MOVE_UPPER_LETTER.getCommand() + "와 " + Command.MOVE_UPPER_LETTER.getCommand() + "중 하냐여야 합니다.")
    ,INPUT_RETRY_COMMAND_FORM("재시작 명령어는 " + Command.GAME_QUIT_LETTER.getCommand() +"(종료)와 " + Command.GAME_RETRY_LETTER.getCommand() + "(재시작) 중 하나여야 합니다.")
    ;

    private final String message;

    IllegalArgumentExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
