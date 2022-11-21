package bridge;

public class Constants {
    public class ErrorMessages {
        public static final String ERROR = "[ERROR] ";
        public static final String THREE_TO_TWENTY = "[ERROR] 3이상 20이하의 정수를 입력해주세요.";
        public static final String UPPER_OR_DOWN = "[ERROR] 위칸을 원하시면 U또는 u, 아래칸을 원하시면 D또는 d를 입력해주세요.";
        public static final String UPPER_OR_DOWN_NO_INPUT = "[ERROR] 위칸을 원하시면 U또는 u, 아래칸을 원하시면 D또는 d를 입력해주세요. 현재 입력값이 없습니다.";
        public static final String RETRY_OR_NOT = "[ERROR] 재시도를 원하시면 R또는 r, 종료를 원하시면 Q또는 q를 입력해주세요.";
        public static final String RETRY_OR_NOT_NO_INPUT = "[ERROR] 재시도를 원하시면 R또는 r, 종료를 원하시면 Q또는 q를 입력해주세요. 현재 입력값이 없습니다.";

    }

    public class GameProcessMessages {
        public static final String INITIAL_MESSAGE = "다리 건너기 게임을 시작합니다.";
        public static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
        public static final String INPUT_WHERETO_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
        public static final String INPUT_RETRY_ORNOT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
        public static final String FINAL_RESULT = "최종 게임 결과";
        public static final String GAME_PASS_OR_NOT = "게임 성공 여부: %s\n";
        public static final String SUCCESS = "성공";
        public static final String FAIL = "실패";
        public static final String ALL_TRIED_COUNTS = "총 시도한 횟수: %s";
    }

    public class UserChoices {
        public static final String QUIT_UPPER = "Q";
        public static final String AGAIN_UPPER = "R";
        public static final String UP_UPPERSTRING = "U";
        public static final String DOWN_UPPERSTRING = "D";

    }

    public class GameElements {
        public static final int MAX_BRIDGE_SIZE = 20;
        public static final int MIN_BRIDGE_SIZE = 3;
        public static final int MAX_RECURSION = 1000;
        public static final int RECURSION_SET_BRIDGE_SIZE  = 0;
        public static final int RECURSION_SET_MOVE_CHOICE  = 1;
        public static final int RECURSION_SET_GAME_COMMAND = 2;

        public static final String EMPTY = " ";
        public static final String CHOICE_EQUALS_DIRECTION = "O";
        public static final String CHOICE_UNEQUALS_DIRECTION = "X";

    }
}
