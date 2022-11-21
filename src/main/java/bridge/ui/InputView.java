package bridge;

import static bridge.Expression.DOWN;
import static bridge.Expression.UP;
import static bridge.UserInterface.RANGE_OUT_OF_EXCEPTION;
import static bridge.UserInterface.SELECT_RE_TRY;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private Exception exception;

    public InputView() {
        this.exception = new Exception();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        String readLine = Console.readLine();
        if ( parseInt(readLine) < 3 || parseInt(readLine) > 20) {
            throw new IllegalArgumentException(RANGE_OUT_OF_EXCEPTION.interact());
        }

        return parseInt(readLine);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

        String readLine = Console.readLine();
        exception.validate(readLine);
        if (readLine.equals("U")) {
            readLine = UP.expressThat();
        }

        if (readLine.equals("D")) {
            readLine = DOWN.expressThat();
        }
        return readLine;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {

        String readLine = Console.readLine();

        exception.validate(readLine);
        if (readLine.equals(SELECT_RE_TRY.interact())) {
            readLine = SELECT_RE_TRY.interact();
        }
        if (readLine.equals(UserInterface.QUIT.interact())){
            readLine = UserInterface.QUIT.interact();
        }

        return readLine;
    }
}
