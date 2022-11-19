package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.validator.BlockValidator.validateInvalidRetryType;
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
        String bridgeSize;
        while(true) {
            try {
                bridgeSize = Console.readLine();
                validateNonNumeric(bridgeSize);
                validateRange(bridgeSize);
                break;
            } catch (IllegalArgumentException e){
                OutputView.printErrorMessage(e);
            }
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        OutputView.printSelectToMovePlayerMessage();
        String moveCommand;
        while (true) {
            try {
                moveCommand = Console.readLine();
                validateInvalidType(moveCommand);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
        return moveCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        OutputView.printAskRetryMessage();
        String retry;
        while (true) {
            try {
                retry = Console.readLine();
                validateInvalidRetryType(retry);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
        return retry;
    }
}
