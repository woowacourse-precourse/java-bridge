package bridge;

public class Constants {
    public static final String ERROR = "[ERROR] ";
    public static final String IS_NOT_NUMBER = ERROR + "다리 길이는 숫자(정수)여야 합니다.";
    public static final String IS_NOT_IN_RANGE = ERROR + "다리 길이는 3 이상, 20 이하의 숫자여야 합니다.";
    public static final String IS_NOT_PROPER_MOVING = ERROR + "이동할 칸은 대문자 U 또는 D 중 하나여야 합니다.";
    public static final String IS_NOT_PROPER_COMMAND = ERROR + "게임 재시작 여부는 대문자 R 또는 Q 중 하나여야 합니다.";
    public static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String RESULT = "최종 게임 결과";
    public static final String IS_SUCCESSFUL = "게임 성공 여부: ";
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";
    public static final String TOTAL_TRIES = "총 시도한 횟수: ";

    public enum MapMark {
        CORRECT("O"),
        WRONG("X"),
        NOTHING(" ");

        private final String letter;

        MapMark(String letter) { this.letter = letter; }
        public String mark() { return letter; }
    }

    public enum MoveMark {
        UP("U"),
        DOWN("D");

        private final String letter;

        MoveMark(String letter) { this.letter = letter; }
        public String mark() { return letter; }
    }

    public enum CommandMark {
        RETRY("R"),
        QUIT("Q");

        private final String letter;

        CommandMark(String letter) { this.letter = letter; }
        public String mark() { return letter; }
    }
}
