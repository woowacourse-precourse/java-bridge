package bridge.view;

public class InputViewConstants {

    public static final String GET_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String GET_PLAYER_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String GET_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String STRING_REGEX = "^[a-zA-Z]*$";
    public static final String NUMBER_REGEX = "^[1-9]*$";
    public static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요 : %s";
    public static final String STRING_FORMAT_ERROR_MESSAGE = "[ERROR] 문자만 입력해주세요 : %s";
    public static final String BLANK_ERROR_MESSAGE = "[ERROR] 빈 문자열은 입력될 수 없습니다.";
    public static final String FORMAT_OPTION_ERROR_MESSAGE = "[ERROR] %s 또는 %s를 입력해주세요";
    public static final String GAME_REPLAY = "R";
    public static final String GAME_QUIT = "Q";
    public static final String UP_STAIR = "U";
    public static final String DOWN_STAIR = "D";
}
