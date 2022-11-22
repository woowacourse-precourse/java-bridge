package bridge.constant;

public class Constants {
    public static class BridgeUtils {
        public static final String BRIDGE_SEPARATOR = " | ";
        public static final String BRIDGE_START = "[ ";
        public static final String BRIDGE_FINISH = " ]";
    }

    public static class BridgeSign {
        public static final String MOVE_PASS = "O";
        public static final String MOVE_FAIL = "X";
        public static final String EMPTY = " ";
        public static final String RETRY = "R";
        public static final String QUIT = "Q";
        public static final String UP = "U";
        public static final String DOWN = "D";
        public static final int RANDOM_UPPER_INCLUSIVE = 1;
        public static final int RANDOM_LOWER_INCLUSIVE = 0;
    }

    public static class Console {
        public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
        public static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
        public static final String INPUT_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
        public static final String CHECK_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
        public static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
        public static final String IS_GAME_WIN_MESSAGE = "게임 성공 여부: %s";
        public static final String TOTAL_TRY_CNT_MESSAGE = "총 시도한 횟수: %d";
        public static final String WIN = "성공";
        public static final String LOSE = "실패";
    }

    public static class Error {
        public static final String ERROR_PREFIX = "[ERROR] ";
        public static final String BRIDGE_SIZE_ERROR_MESSAGE = ERROR_PREFIX + "다리 길이가 3이상 20이하의 값이 아닙니다.";
        public static final String MOVE_DIRECTION_ERROR_MESSAGE = ERROR_PREFIX + "입력값이 U 또는 D가 아닙니다.";
        public static final String RETRY_ERROR_MESSAGE = ERROR_PREFIX + "입력값이 R 또는 Q가 아닙니다.";
        public static final String INPUT_VALUE_FORMAT_ERROR_MESSAGE = ERROR_PREFIX + "입력받은 값이 숫자 형태가 아닙니다.";
    }
}
