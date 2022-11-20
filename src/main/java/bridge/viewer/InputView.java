package bridge.viewer;

import bridge.exception.ExceptionPrinter;
import bridge.util.Converter;
import bridge.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String inputBridgeSizeMessage = "다리의 길이를 입력해주세요.";
    private final String inputMoveMessage = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String inputRetryMessage = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final InputValidator validator;

    public InputView(InputValidator validator) {
        this.validator = validator;
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while(true) {
            System.out.println(inputBridgeSizeMessage);
            try {
                String inputValue = Console.readLine();
                int bridgeSize = Converter.stringToInt(inputValue);
                validator.validateBridgeSize(bridgeSize);
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                ExceptionPrinter.printException(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while(true) {
            System.out.println(inputMoveMessage);
            try {
                String move = Console.readLine();
                validator.validateMove(move);
                return move;
            } catch (IllegalArgumentException e) {
                ExceptionPrinter.printException(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readRetry() {
        while(true) {
            System.out.println(inputRetryMessage);
            try {
                String retryQuit = Console.readLine();
                validator.validateRetry(retryQuit);
                return Converter.retryQuitToBoolean(retryQuit);
            } catch (IllegalArgumentException e) {
                ExceptionPrinter.printException(e.getMessage());
            }
        }
    }
}
