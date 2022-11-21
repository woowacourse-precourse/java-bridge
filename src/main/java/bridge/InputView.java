package bridge;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final String Error_NotNumber = "[ERROR] 숫자만 입력해 주세요!";
    public static final String Error_NotString = "[ERROR] 문자만 입력해 주세요!";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return inputBridgeSize();
    }

    private static int inputBridgeSize() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(Error_NotNumber);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return inputMoving();
    }

    private static String inputMoving() {
        try {
            return String.valueOf(Console.readLine());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(Error_NotString);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return inputGameCommand();
    }

    private static String inputGameCommand() {
        try {
            return String.valueOf(Console.readLine());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(Error_NotString);
        }
    }
}
