package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.Command;
import bridge.domain.Direction;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INSERT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INSERT_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INSERT_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String REQUIRE_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";

    OutputView outputView = new OutputView();


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            int BridgeSize = getBridgeSizeByConsole();
            Bridge.validateLength(BridgeSize);
            return BridgeSize;
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return readBridgeSize();
        }
    }

    private int getBridgeSizeByConsole() {
        try {
            outputView.printMessage(INSERT_BRIDGE_SIZE_MESSAGE);
            String userInput = Console.readLine();
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            outputView.printErrorMessage(REQUIRE_INTEGER_ERROR_MESSAGE);
            return getBridgeSizeByConsole();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readDirection() {
        outputView.printMessage(INSERT_DIRECTION_MESSAGE);
        try {
            Direction direction = Direction.getDirectionByString(Console.readLine());
            return direction;
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return readDirection();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        outputView.printMessage(INSERT_COMMAND_MESSAGE);
        try {
            Command command = Command.getCommandByString(Console.readLine());
            return command;
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return readGameCommand();
        }
    }
}
