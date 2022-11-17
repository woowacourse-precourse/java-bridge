package bridge;


/**
 * 사용자의 입력을 검증하는 역할을 한다.
 */
public class InputViewValidator {
    private final static int BRIDGE_MIN_SIZE = 3;
    private final static int BRIDGE_MAX_SIZE = 20;

    /**
     * 입력 받은 숫자가 정수 형태인지 확인한다.
     * @param str 검증할 값
     * @throws IllegalArgumentException 숫자 외 다른 값이 들어가 있는 경우
     */
    public static void validateNumberFormat(String str) throws IllegalArgumentException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요!");
        }
    }

    /**
     * 다리의 길이가 사전에 설정한 범위에 있는 지 검증합니다.
     * @param n 다리의 길이
     * @throws IllegalArgumentException 다리의 길이가 범위 밖에 있는 경우
     */
    public static void validateBridgeLength(int n) throws IllegalArgumentException {
        if (!(BRIDGE_MIN_SIZE <= n && n <= BRIDGE_MAX_SIZE))
            throw  new IllegalArgumentException("다리의 길이는 3이상 20이하여야 합니다.");
    }
}
