package bridge.view;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Direction;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INSERT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INSERT_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String REQUIRE_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";

    OutputView outputView = new OutputView();


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int BridgeSize = getBridgeSizeByConsole();
        try {
            Bridge.validateLength(BridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            readBridgeSize();
        }
        return BridgeSize;
    }

    private int getBridgeSizeByConsole() {
        outputView.printMessage(INSERT_BRIDGE_SIZE_MESSAGE);
        String userInput = Console.readLine();
        try {
            intValidation(userInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            getBridgeSizeByConsole();
        }
        return Integer.parseInt(userInput);
    }

    private void intValidation(String input) {
        final String intRegex = "^[0-9]*$";
        if (Pattern.matches(intRegex, input)) {
            throw new IllegalArgumentException(new IllegalArgumentException(REQUIRE_INTEGER_ERROR_MESSAGE));
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readDirection() {
        outputView.printMessage(INSERT_DIRECTION_MESSAGE);
        Direction direction = null;
        try {
            Direction.getDirectionByString(Console.readLine());
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            readDirection();
        }
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
