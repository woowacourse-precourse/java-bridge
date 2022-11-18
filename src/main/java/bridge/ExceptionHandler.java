package bridge;

import java.util.Objects;

public class ExceptionHandler {

    private static final String ERROR_MESSAGE = "[ERROR]";
    public static int checkSizeType(String str) {
        int size;
        try {
            size = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 다리 길이는 숫자만 입력할 수 있습니다.");
        }
        return size;
    }

    public static void checkSizeRange(int size) {
        if (size < 3 || size > 20)
            throw new IllegalArgumentException(ERROR_MESSAGE + " 다리 길이는 3~20 사이의 숫자여야 합니다.");
    }

    public static int sizeExceptionHandler(String readValue) {
        int size;
        try {
            size = checkSizeType(readValue);
            checkSizeRange(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            size = Application.inputSize();
        }
        return size;
    }

    public static void checkMove(String move) {
        if (!Objects.equals(move, "U") && !Objects.equals(move, "D"))
            throw new IllegalArgumentException(ERROR_MESSAGE + "이동할 칸은 \"U\"나 \"D\"만 입력할 수 있습니다.");
    }

    public static void moveExceptionHandler(String move) {
        try {
            checkMove(move);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkGameCommand(String gameCommand) {
        if (!Objects.equals(gameCommand, "R") && !Objects.equals(gameCommand, "Q"))
            throw new IllegalArgumentException(ERROR_MESSAGE + "재시작하려면 \"R\", 종료하려면\"Q\"를 입력해주세요.");
    }

    public static void gameCommandExceptionHandler(String gameCommand) {
        try {
            checkGameCommand(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
