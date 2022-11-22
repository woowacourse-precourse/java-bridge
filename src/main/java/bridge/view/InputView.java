package bridge.view;

import bridge.Constants;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final List<String> UPPER_OR_DOWNS = List.of("U","D");
    public static final List<String> RETRY_OR_QUITS = List.of("R","Q");

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() throws IllegalArgumentException {
        try {
            int length = Integer.parseInt(Console.readLine());
            if (length > Constants.GameElements.MAX_BRIDGE_SIZE || length < Constants.GameElements.MIN_BRIDGE_SIZE) {
                throw new IllegalArgumentException(Constants.ErrorMessages.THREE_TO_TWENTY);
            }
            return length;
        } catch (NumberFormatException | NoSuchElementException ne) {
            throw new IllegalArgumentException(Constants.ErrorMessages.THREE_TO_TWENTY);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() throws IllegalArgumentException{
        try {
            String s = Console.readLine();

            throwError(UPPER_OR_DOWNS, s, Constants.ErrorMessages.UPPER_OR_DOWN);

            return s;
        } catch (NoSuchElementException ne) {
            throw new IllegalArgumentException(Constants.ErrorMessages.UPPER_OR_DOWN_NO_INPUT);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() throws IllegalArgumentException{
        try {
            String s = Console.readLine();

            throwError(RETRY_OR_QUITS, s, Constants.ErrorMessages.RETRY_OR_NOT);

            return s;
        } catch (NoSuchElementException ne) {
            throw new IllegalArgumentException(Constants.ErrorMessages.RETRY_OR_NOT_NO_INPUT);
        }
    }

    public static void throwError(List<String> properElements, String input, String errorMessage) throws IllegalArgumentException {
        if (!properElements.contains(input)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
