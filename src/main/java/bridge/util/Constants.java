package bridge.util;

public class Constants {

    // 입력 View 관련 메시지 관련 상수
    public static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    public static final String INPUT_BRIDGE_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    // 출력 View 관련 메시지 관련 상수
    public static final String OUTPUT_BRIDGE_GAME_START = "다리 건너기 게임을 시작합니다.";

    // 에러 메시지 관련 상수
    public static final String ERROR = "[ERROR] ";
    public static final String ERROR_BRIDGE_NULL = ERROR + "다리 길이에 NULL은 불가합니다.";
    public static final String ERROR_BRIDGE_RANGE = ERROR + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String ERROR_LOCATION_EMPTY = ERROR + "이동할 칸에 NULL은 불가합니다.";
    public static final String ERROR_LOCATION_RIGHT_LENGTH = ERROR + "이동할 칸의 입력 길이는 1이어야 합니다.";
    public static final String ERROR_LOCATION_RIGHT_FORM = ERROR + "이동할 칸의 입력은 \"U\" 또는 \"D\"만이 가능합니다.";
}
