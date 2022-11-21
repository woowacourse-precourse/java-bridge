package bridge.view;

import bridge.BridgeValidUtil;
import bridge.constant.BridgeMark;
import bridge.constant.GameCommand;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 *
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {

    public static final String NUMBER_REGEX = "^[0-9]*$";
    public static final String ERROR_INVALID_BRIDGE_NUMBER = "[ERROR] 다리의 길이는 숫자이어야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String size = Console.readLine();
        try {
            validate(size);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            OutputView.printBridgeSize();
            return readBridgeSize();
        }
        return Integer.parseInt(size);
    }

    private static void validate(String size) {
        validateIsNumber(size);
        BridgeValidUtil.validateSize(Integer.parseInt(size));
    }

    public static void validateIsNumber(String size) {
        if (!isNumber(size)) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_NUMBER);
        }
    }

    private static boolean isNumber(String size) {
        return Pattern.matches(NUMBER_REGEX, size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String movingMark = Console.readLine();
        try {
            BridgeMark.validateInput(movingMark);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            OutputView.printMove();
            return readMoving();
        }
        return movingMark;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String command = Console.readLine();
        try {
            GameCommand.validateInput(command);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            OutputView.printRestart();
            return readGameCommand();
        }
        return command;
    }
}
