package bridge.view;

import bridge.Constants;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        try {
            int length = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
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
    public String readMoving() throws IllegalArgumentException{
        try {
            String s = camp.nextstep.edu.missionutils.Console.readLine();

            throwError(List.of("U","D"), s, Constants.ErrorMessages.UPPER_OR_DOWN);

            return s;
        } catch (NoSuchElementException ne) {
            throw new IllegalArgumentException(Constants.ErrorMessages.UPPER_OR_DOWN_NO_INPUT);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException{
        try {
            String s = Console.readLine();

            throwError(List.of("R","Q"), s, Constants.ErrorMessages.RETRY_OR_NOT);

            return s;
        } catch (NoSuchElementException ne) {
            throw new IllegalArgumentException(Constants.ErrorMessages.RETRY_OR_NOT_NO_INPUT);
        }
    }

    public void throwError(List<String> properElements, String input, String errorMessage) throws IllegalArgumentException {
        if (!properElements.contains(input)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
