package bridge;

public class ErrorMessageGenerator {
    private static final String ERROR_MESSAGE = "[ERROR]";

    /**
     * 에러 메시지 생성 메서드
     *
     * @param message 출력하고자 하는 에러 메시지
     * @return "[ERROR]" + "출력하고자 하는 메세지"
     */
    public static String generate(String message) {
        StringBuilder errorMessage = new StringBuilder(ERROR_MESSAGE);

        errorMessage.append(message);
        return errorMessage.toString();
    }
}
