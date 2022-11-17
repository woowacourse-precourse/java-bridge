package bridge.view;

import static bridge.view.OutputView.INPUT_BRIDGE_LENGTH_MESSAGE;
import static bridge.view.OutputView.printMessageWithNewline;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        printMessageWithNewline(INPUT_BRIDGE_LENGTH_MESSAGE);
        String input = readLine();
        return getAnInt(input);
    }

    private static int getAnInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
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
