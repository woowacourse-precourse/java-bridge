package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.util.Constant.OUTPUT_VIEW;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public InputView() {
        super();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String readLine;
        do {
            readLine = Console.readLine();
        } while (!readLine.equals(OUTPUT_VIEW.printBridgeLengthInputErrorMessage(readLine)));
        return Integer.parseInt(readLine);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String readLine;
        do {
            readLine = Console.readLine();
        } while (!readLine.equals(OUTPUT_VIEW.printMovingBlockInputErrorMessage(readLine)));
        return readLine;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String readLine;
        do {
            readLine = Console.readLine();
        } while (!readLine.equals(OUTPUT_VIEW.printRestartInputErrorMessage(readLine)));
        return readLine;
    }
}
