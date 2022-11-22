package bridge.viewer;

import bridge.exception.ExceptionMessage;
import bridge.exception.ExceptionPrinter;
import bridge.gameComponent.InputValidator;
import bridge.gameComponent.InputValidatorImpl;
import bridge.util.Converter;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
//    public int readBridgeSize() {
//        System.out.println(inputBridgeSizeMessage);
//        while(true) {
//            try {
//                String inputValue = Console.readLine();
//                int bridgeSize = Converter.stringToInt(inputValue);
//                validator.validateBridgeSize(bridgeSize);
//                return bridgeSize;
//            } catch (IllegalArgumentException e) {ExceptionPrinter.printException(e.getMessage());}
//        }
//    }
    public int readBridgeSize() {
        System.out.println(inputBridgeSizeMessage);
        String size = validator.inputTemplate("validateBridgeSize");
        return Converter.stringToInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(inputMoveMessage);
        String move = validator.inputTemplate("validateMove");
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readRetry() {
        System.out.println(inputRetryMessage);
        String retry = validator.inputTemplate("validateRetry");
        return Converter.retryQuitToBoolean(retry);
    }
}
