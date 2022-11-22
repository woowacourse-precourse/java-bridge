package bridge.util;

public class Constants {

    public class Message {
        public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
        public static final String INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
        public static final String INPUT_CROSS_THE_BRIDGE_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
        public static final String INPUT_RESTART_OR_EXIT_MESSAGE
                = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
        public static final String FINAL_GAME_RESULT_MESSAGE = "\n최종 게임 결과";
        public static final String GAME_RESULT_MESSAGE = "\n게임 성공 여부: ";
        public static final String SUCCESS_MESSAGE = "성공";
        public static final String FAIL_MESSAGE = "실패";
        public static final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: ";
    }

    public class ErrorMessage {
        public static final String BRIDGE_SIZE_ERROR = "[ERROR] 다리의 길이는 3 이상 20 이하의 숫자만 입력 가능합니다.";
        public static final String INCORRECT_MOVING_ERROR = "[ERROR] 이동할 칸은 U 또는 D만 입력 가능합니다.";
        public static final String INCORRECT_GAME_COMMAND_ERROR = "[ERROR] 재시작은 R, 종료는 Q만 입력 가능합니다.";
    }

    public class Constant {
        public static final String SUCCESS = " O ";
        public static final String FAIL = " X ";
        public static final String BLANK = "   ";
        public static final String UPSIDE = "U";
        public static final String DOWN = "D";
        public static final String RESTART = "R";
        public static final String QUIT = "Q";
        public static final int BRIDGE_SIZE_MIN = 3;
        public static final int BRIDGE_SIZE_MAX = 20;
        public static final String CHECK_NUMBER_ONLY = "[0-9]+";
    }
}
