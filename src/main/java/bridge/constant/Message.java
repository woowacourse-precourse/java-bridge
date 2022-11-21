package bridge.constant;

public final class Message {

    public static final String START_BRACKET = "[ ";
    public static final String END_BRACKET = " ]";
    public static final String VERTICAL_BAR = " | ";

    public static final class InputExceptionMessage {

        public static final String WRONG_BRIDGE_SIZE = "[ERROR] 다리 길이는 3과 20 사이의 숫자여야 합니다.";
        public static final String WRONG_MOVING = "[ERROR] 다리 이동은 'U(위)' 또는 'D(아래)'여야 합니다.";
        public static final String WRONG_GAME_COMMAND = "[ERROR] 재시도 관련 명령어는 'R(재시작)' 또는 'Q(종료)'여야 합니다.";

        private InputExceptionMessage() {}
    }

    public static final class InputViewMessage {

        public static final String BRIDGE_LENGTH_REQUEST = "다리의 길이를 입력해주세요.";
        public static final String MOVING_REQUEST = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
        public static final String RETRY_REQUEST = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

        private InputViewMessage() {}

    }

    public static final class OutputViewMessage {

        public static final String FINAL_GAME_RESULT = "최종 게임 결과";
        public static final String GAME_SUCCESS_OR_NOT= "게임 성공 여부: ";
        public static final String TOTAL_NUMBER_OF_ATTEMPTS = "총 시도한 횟수: ";
        public static final String GAME_START_NOTICE = "다리 건너기 게임을 시작합니다.";

        private OutputViewMessage() {}
    }
}
