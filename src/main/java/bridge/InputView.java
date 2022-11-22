package bridge;

import bridge.model.ValidityCheck;
import camp.nextstep.edu.missionutils.Console;

import static bridge.OutputView.printStartGame;
import static bridge.enums.DorU.*;
import static bridge.enums.ErrorMessage.*;
import static bridge.enums.Sentence.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final static ValidityCheck validityCheck = new ValidityCheck();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int getBridgeLength() {
        printStartGame();
        System.out.println(INPUT_BRIDGE_LENGTH.getValue());
        String inputBridgeLength = Console.readLine();
        if (!validityCheck.numberRangeChecker(inputBridgeLength) || !validityCheck.stringChecker(inputBridgeLength)) {
            throw new IllegalArgumentException(ER_BRIDGE_LENGTH_INPUT.getMessage());
        }
        return Integer.parseInt(inputBridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String getMoveString() {
        System.out.println(MOVE.getValue());
        String inputUpOrDown = Console.readLine();
        if (!(inputUpOrDown.equals(UP.getName()) || inputUpOrDown.equals(DOWN.getName()))) {
            throw new IllegalArgumentException(ER_NOT_UP_OR_DOWN.getMessage());
        }
        return inputUpOrDown;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
