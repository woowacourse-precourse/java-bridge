package bridge;

import java.util.Objects;

public class ExceptionHandler {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String RETRY_MESSAGE = "다시 시도해 주세요.";
    public static int checkSizeType(String str) {
        int size;
        try {
            size = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 다리 길이는 숫자만 입력할 수 있습니다. " + RETRY_MESSAGE);
        }
        return size;
    }

    public static void checkSizeRange(int size) {
        if (size < 3 || size > 20)
            throw new IllegalArgumentException(ERROR_MESSAGE + " 다리 길이는 3~20 사이의 숫자여야 합니다. " + RETRY_MESSAGE);
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
            throw new IllegalArgumentException(ERROR_MESSAGE + "이동할 칸은 \"U\"나 \"D\"만 입력할 수 있습니다. " + RETRY_MESSAGE);
    }

    public static String moveExceptionHandler(String move) {
        try {
            checkMove(move);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            move = Application.inputMove();
        }
        return move;
    }

    public static void checkGameCommand(String gameCommand) {
        if (!Objects.equals(gameCommand, "R") && !Objects.equals(gameCommand, "Q"))
            throw new IllegalArgumentException(ERROR_MESSAGE + "재시작 시 \"R\", 종료 시\"Q\"만 입력할 수 있습니다. " + RETRY_MESSAGE);
    }

    public static String gameCommandExceptionHandler(String gameCommand) {
        try {
            checkGameCommand(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            gameCommand = Application.inputGameCommand();
        }
        return gameCommand;
    }
}
