package bridge.model;

public enum GameCommand {
    R, Q;
    public static final String RETRY_GAME_FORMAT_STRING = "R";
    public static final String QUIT_GAME_FORMAT_STRING = "Q";
    private static final String ERR_GAME_COMMAND_FORMAT = "[ERROR] 게임 재시도는 'R', 종료는 'Q'를 입력하세요. 대소문자 구별. 예시) R(O), Q(O), r(X)";
    public static GameCommand toGameCommand(String format) {
        if (format.equals(RETRY_GAME_FORMAT_STRING) || format.equals(QUIT_GAME_FORMAT_STRING)) {
            return GameCommand.valueOf(format);
        }
        throw new IllegalArgumentException(ERR_GAME_COMMAND_FORMAT);
    }

}
