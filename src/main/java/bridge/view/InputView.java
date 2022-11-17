package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

import static bridge.validator.BlockValidator.validateInvalidType;
import static bridge.validator.NumberValidator.validateNonNumeric;
import static bridge.validator.NumberValidator.validateRange;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        OutputView.printBridgeLengthInputMessage();
        String bridgeSize = Console.readLine();

        validateNonNumeric(bridgeSize);
        validateRange(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        OutputView.printSelectToMovePlayerMessage();
        String moveCommand = Console.readLine();

        validateInvalidType(moveCommand);
        return moveCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
