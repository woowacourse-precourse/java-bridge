package bridge.view;

import bridge.model.GameDTO;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String inputData;
        int bridgeSize;

        inputData = Console.readLine();
        bridgeSize = Integer.parseInt(inputData);
        return bridgeSize;
    }

    public String readMoving() {
        String inputData;

        inputData = Console.readLine();
        return inputData;
    }

    public String readGameCommand() {
        String inputData;

        inputData = Console.readLine();
        return inputData;
    }
}
