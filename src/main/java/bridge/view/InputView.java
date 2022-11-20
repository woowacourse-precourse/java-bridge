package bridge.view;

import bridge.constant.Constant;
import bridge.constant.ErrorMessage;
import bridge.constant.Message;
import bridge.enums.Bridge;
import camp.nextstep.edu.missionutils.Console;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.START_GAME);
        System.out.println(Message.REQUEST_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        System.out.println();

        boolean isThrowError = validate(this::validateBridgeSize, bridgeSize);
        if (isThrowError) {
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    private void validateBridgeSize(String bridgeSize) {
        if (!Pattern.matches(Constant.BRIDGE_SIZE_REGEX, bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER);
        }

        if (isInvalidBridgeSize(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_BRIDGE_SIZE);
        }
    }

    private boolean isInvalidBridgeSize(int bridgeSize) {
        return bridgeSize < Constant.BRIDGE_SIZE_MIN || bridgeSize > Constant.BRIDGE_SIZE_MAX;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.REQUEST_MOVE_TO_PLACE);
        String moveToBridge = Console.readLine();

        boolean isThrowError = validate(this::validateMoveToBridge, moveToBridge);
        if (isThrowError) {
            return readMoving();
        }
        return moveToBridge;
    }

    private void validateMoveToBridge(String moveToBridge) {
        Bridge sign = Bridge.findBySign(moveToBridge);
        if (sign == Bridge.NOTHING) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_MOVE_TO_PLACE_FORM);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    public boolean validate(Consumer<String> validateFunction, String input) {
        try {
            validateFunction.accept(input);
        } catch (IllegalArgumentException e) {
            System.out.printf(ErrorMessage.ERROR_MESSAGE_FORM, e.getMessage());
            return true;
        }
        return false;
    }

}
