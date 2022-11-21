package bridge.commom.constant;

public class GameMessage {

    public static class Exception {

        public static final String NO_ALTER_KEY = "대응되는 키가 존재하지 않습니다.";
        public static final String BRIDGE_SIZE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
        public static final String POSITIVE_INTEGER = "양의 정수만 입력할 수 있습니다.";
        public static final String MOVE_MODE_COMMAND = "U(위로 이동) 혹은 D(아래로 이동) 중 하나를 입력해야합니다.";
        public static final String RESTART_MODE_COMMAND = "R(재시작) 혹은 Q(종료) 중 하나를 입력해야합니다.";
        public static final String ERROR_HEADER = "[ERROR] ";
    }

    public static class InputMessage {

        public static final String READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
        public static final String READ_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
        public static final String READ_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    }

    public static class OutputMessage {

        public static final String RESULT_DELIMITER = " | ";
        public static final String RESULT_CLOSE_BRACKET = " ]";
        public static final String RESULT_OPEN_BRACKET = "[ ";
        public static final String PRINT_GREETING = "다리 건너기 게임을 시작합니다.";
        public static final String PRINT_RESULT_HEADER = "최종 게임 결과";
        public static final String IS_SUCCESS = "게임 성공 여부: ";
        public static final String TOTAL_TRY = "총 시도한 횟수: ";
    }

}
