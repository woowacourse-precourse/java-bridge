package bridge;

public final class Constants {
    public final class ErrorState {
        public static final String BRIDGE_SIZE = "[ERROR] 3이상 20이하의 숫자를 입력해 주세요";
        public static final String DIRECTION = "[ERROR] 위로가려면 U, 아래로 가려면 D를 입력해 주세요";
        public static final String COMMAND = "[ERROR] 재시도를 하려면 R, 종료하려면 Q를 입력해 주세요";

        private ErrorState() {
        }
    }

    public final class OutputState {
        public static final String START_GAME = "다리 건너기 게임을 시작합니다.";
        public static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
        public static final String INPUT_MOVE_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
        public static final String INPUT_RETRY_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
        public static final String GAME_RESULT = "최종 게임 결과";
        public static final String SUCCESS_OR_NOT = "게임 성공 여부: ";
        public static final String TOTAL_ATTEMPT = "총 시도한 횟수: ";

        private OutputState() {
        }
    }

    public final class BridgeShape {
        public static final String START_LINE = "[";
        public static final String END_LINE = "]";
        public static final String SEPERATOR = "|";
        public static final String MOVABLE = " O ";
        public static final String UNMOVABLE = " X ";
        public static final String BLANK = "   ";

        private BridgeShape() {
        }
    }

    public final class Command {
        public static final String UP = "U";
        public static final String DOWN = "D";
        public static final String RETRY = "R";
        public static final String QUIT = "Q";
    }

    public final class Result{
        public static final String SUCCESS = "성공";
        public static final String FAIL = "실패";
    }
}
