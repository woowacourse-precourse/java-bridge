package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static bridge.ExceptionMessage.BRIDGE_LENGTH_ERROR_MESSAGE;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            return (parseBridgeSize(readLine()));
        } catch (NumberFormatException ex) {
            throw (new IllegalArgumentException(BRIDGE_LENGTH_ERROR_MESSAGE.toString()));
        }
    }

    private int parseBridgeSize(String userInput) {
        int minLength = 3;
        int maxLength = 20;
        int parsed = Integer.parseInt(userInput);
        if (parsed < minLength || maxLength < parsed) {
            throw (new NumberFormatException());
        }
        return (parsed);
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
