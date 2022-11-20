package bridge;
import bridge.exception.ValidException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final ValidException validException;

    InputView(ValidException exception){
        this.validException = exception;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return validBridgeSize(Console.readLine());
    }

    private int validBridgeSize(String bridgeLengthOfString) {
        validException.validInteger(bridgeLengthOfString);
        validException.validIntegerRange(Integer.parseInt(bridgeLengthOfString));

        return Integer.parseInt(bridgeLengthOfString);
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
