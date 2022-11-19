package bridge.util;

public class Constants {

    public static class ExceptionConstants {
        public static final String ERROR_TITLE = "[ERROR] ";

        public static final String INTEGER_ONLY_REGEX = "[0-9]+";
        public static final String INPUT_ONLY_INTEGER = "정수만 입력할 수 있습니다.";
        public static final String BRIDGE_SIZE_BETWEEN_3_AND_20 = "다리의 길이는 3 이상 20 이하만 입력할 수 있습니다.";
        public static final String INPUT_LENGTH_ONLY_1 = "하나의 알파벳만 입력할 수 있습니다.";
        public static final String INPUT_ONLY_U_OR_D = "U 또는 D만 입력할 수 있습니다.";
    }

    public static class OutputViewConstants {
        public static final String BRIDGE_START = "[";
        public static final String BRIDGE_END = "]";
        public static final String UP = "U";
        public static final String DOWN = "D";
        public static final String ZERO_AND_STICK = " O |";
        public static final String STICK = "   |";
        public static final String ZERO = " O ";
        public static final String EMPTY = "   ";
        public static final String X = " X ";

        public static final String START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.";
        public static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
        public static final String INPUT_SELECT_MOVE_BLOCK = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
        public static final String WHETHER_GAME_CLEAR = "게임 성공 여부: ";
        public static final String RETRY_COUNT = "총 시도한 횟수: ";
        public static final String SUCCESS = "성공";
        public static final String FAIL = "실패";
        public static final String GAME_RESULT = "최종 게임 결과";
    }

    public static class InputViewConstants {
        public static final String RESTART_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
        public static final String RESTART = "R";
        public static final String QUIT = "Q";
    }

}
