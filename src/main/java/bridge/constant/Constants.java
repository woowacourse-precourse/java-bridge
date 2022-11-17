package bridge.constant;

public class Constants {
    public static class BridgeUtils {

        public static final String BRIDGE_SEPARATOR = " | ";
        public static final String BRIDGE_START = "[ ";
        public static final String BRIDGE_FINISH = " ]";
    }

    public static class BridgeSign {
        public static final String PASS = "O";
        public static final String FAIL = "X";
        public static final String RETRY = "R";
        public static final String QUIT = "Q";
        public static final String UP = "U";
        public static final String DOWN = "D";
    }

    public static class Console {
        public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
        public static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
        public static final String INPUT_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
        public static final String CHECK_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
        public static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
        public static final String IS_GAME_WIN_MESSAGE = "게임 성공 여부: %s";
        public static final String TOTAL_TRY_CNT_MESSAGE = "총 시도한 횟수: $d";
    }
}
