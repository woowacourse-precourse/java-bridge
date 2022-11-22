package bridge;

import static bridge.Expression.DOWN;
import static bridge.Expression.UP;
import static bridge.GameStatus.QUIT;
import static bridge.GameStatus.SELECT_RE_TRY;
import static bridge.UserInterface.INSERT_SIZE;
import static bridge.UserInterface.RANGE_OUT_OF_EXCEPTION;
import static bridge.UserInterface.RE_TRY;
import static bridge.UserInterface.SELECT_ROW;
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

        System.out.println(INSERT_SIZE.interact());
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

        System.out.println(SELECT_ROW.interact());
        String readLine = Console.readLine();
        Expression.validate(readLine);

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

        System.out.println(RE_TRY.interact());
        String readLine = Console.readLine();

        GameStatus.validate(readLine);
        if (readLine.equals(SELECT_RE_TRY.tellCommand())) {
            readLine = SELECT_RE_TRY.tellCommand();
        }
        if (readLine.equals(QUIT.tellCommand())){
            readLine = QUIT.tellCommand();
        }

        return readLine;
    }
}
