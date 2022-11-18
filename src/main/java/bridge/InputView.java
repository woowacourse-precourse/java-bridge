package bridge;

import static bridge.Expression.DOWN;
import static bridge.Expression.QUIT;
import static bridge.Expression.RE_TRY;
import static bridge.Expression.UP;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private String readLine;

    public InputView(String readLine) {
        this.readLine = Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        return parseInt(readLine);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

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

        if (readLine.equals("R")) {
            readLine = RE_TRY.expressThat();
        }
        if (readLine.equals("Q")){
            readLine = QUIT.expressThat();
        }

        return readLine;
    }
}
