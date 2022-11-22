package bridge;

public class Utils {
    static final int MIN_SIZE = 3;
    static final int MAX_SIZE = 20;
    static final int DOWN_NUM = 0;
    static final int UP_NUM = 1;
    static final String DOWN_STRING = "D";
    static final String UP_STRING = "U";
    static final String BLANK = " ";
    static final int FAIL = -1;
    static final int CONTINUE = 0;
    static final int SUCCESS = 1;
    static final String RESTART = "R";
    static final String EXIT = "Q";
    public static final int LIMIT = 10;

    static boolean isValidSize(int size) {
        return size >= MIN_SIZE && size <= MAX_SIZE;
    }

    static boolean isValidDirection(String dir) {
        return dir.equals(UP_STRING) || dir.equals(DOWN_STRING);
    }

    static boolean isValidCommand(String command) {
        return command.equals(EXIT) || command.equals(RESTART);
    }
}
