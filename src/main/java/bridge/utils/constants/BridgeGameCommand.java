package bridge.utils.constants;

public class BridgeGameCommand {
    public static final String READ_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String ERROR_GAME_COMMAND = "[ERROR] 다시 입력하세요. (재시도: R, 종료: Q)";
    public static final String GAME_COMMAND_REGEX = "^R{1}$|^Q{1}$";
    public static final String RETRY = "R";
}
