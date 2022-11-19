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
     * @throws IllegalArgumentException 입력받은 다리의 길이가 1 이상의 정수가 아닌 경우
     */
    public static void validateBridgeLengthInput(String input) {
        validateBridgeLengthFormat(input);
        validateBridgeLengthRange(Integer.parseInt(input));
    }

    /**
     * 입력받은 다음 이동할 칸이 정상적인 입력 (U 또는 D)인지 판단하는 메서드입니다.
     * @param input 입력받은 다음 이동할 칸에 해당하는 문자열
     * @throws IllegalArgumentException U 또는 D가 아닌 경우
     */
    public static void validateNextCell(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            System.out.println(ERROR_PREFIX + "위: U 또는 아래: D를 입력해주세요!");
            throw new IllegalArgumentException(ERROR_PREFIX + "위: U 또는 아래: D를 입력해주세요!");
        }
    }

    /**
     * 입력받은 재시작 여부 문자열이 정상적인 입력 (R 또는 Q)인지 판단하는 메서드입니다.
     * @param input 입력받은 재시작 여부에 해당하는 문자열
     * @throws IllegalArgumentException R 또는 Q가 아닌 경우
     */
    public static void validateRestartInput(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            System.out.println(ERROR_PREFIX + "재시도: R 또는 종료: Q를 입력해주세요!");
            throw new IllegalArgumentException(ERROR_PREFIX + "재시도: R 또는 종료: Q를 입력해주세요!");
        }
    }

    /**
     * 다리의 길이가 문자로 이루어지지 않은 정수형인지 판단하는 메서드입니다.
     * @param input 입력받은 다리의 길이에 해당하는 문자열
     * @throws IllegalArgumentException 입력받은 다리가 정수로 이루어지지 않은 경우
     */
    private static void validateBridgeLengthFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_PREFIX + "다리의 길이는 정수로 입력해주세요!");
            throw new IllegalArgumentException(ERROR_PREFIX + "다리의 길이는 정수로 입력해주세요!");
        }
    }

    /**
     * 다리의 길이가 1 이상인지 판단하는 메서드입니다.
     * @param length 다리의 길이
     * @throws IllegalArgumentException 다리의 길이가 0 이하인 경우
     */
    private static void validateBridgeLengthRange(int length)  {
        if (length <= 0) {
            System.out.println(ERROR_PREFIX + "다리의 길이는 1 이상이어야 합니다!");
            throw new IllegalArgumentException(ERROR_PREFIX + "다리의 길이는 1 이상이어야 합니다!");
        }
    }
}
