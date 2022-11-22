package bridge;

public class Constants {
    public static final String ERROR = "[ERROR] ";
    public static final String IS_NOT_NUMBER = ERROR + "다리 길이는 숫자(정수)여야 합니다.";
    public static final String IS_NOT_IN_RANGE = ERROR + "다리 길이는 3 이상, 20 이하의 숫자여야 합니다.";
    public static final String IS_NOT_PROPER_MOVING = ERROR + "이동할 칸은 대문자 U 또는 D 중 하나여야 합니다.";
    public static final String IS_NOT_PROPER_COMMAND = ERROR + "게임 재시작 여부는 대문자 R 또는 Q 중 하나여야 합니다.";

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
