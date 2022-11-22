package bridge;

public class ExceptionHandler {
    static final int ERROR = -1;

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    public static boolean exeedLimit(int limit) {
        return limit > Utils.LIMIT;
    }

    public static void handleSizeException(int size) throws IllegalArgumentException {
        if (!Utils.isValidSize(size)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void handleMovingException(String dir) throws IllegalArgumentException {
        if (!Utils.isValidDirection(dir)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D여야 합니다.");
        }
    }

    public static void handleCommandException(String command) throws IllegalArgumentException {
        if (!Utils.isValidCommand(command)) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q가 입력되어야 합니다.");
        }
    }
}
