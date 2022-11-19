package bridge.input;

/**
 * InputView 클래스에서 사용자 입력을 받을 때 발생할 수 있는 예외 처리를 담당하는 클래스입니다.
 * @version 1.0.0
 * @author CHO Min HO
 */
public class InputExceptionHandler {

    private static final String ERROR_PREFIX = "[ERROR] ";

    /**
     * 다리의 길이에 해당하는 문자열에 대해 1 이상의 정수인지 판단하는 메서드입니다.
     * @param input 입력받은 다리의 길이에 해당하는 문자열
     * @throws IllegalStateException 입력받은 다리의 길이가 1 이상의 정수가 아닌 경우
     */
    public static void validateBridgeLengthInput(String input) {
        int length = 0;
        try {
            length = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + "다리의 길이는 정수로 입력해주세요!");
        }
        if (length <= 0) throw new IllegalArgumentException(ERROR_PREFIX + "다리의 길이는 1 이상이어야 합니다!");
    }
}
