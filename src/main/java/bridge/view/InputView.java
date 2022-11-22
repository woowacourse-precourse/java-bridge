package bridge.view;
import bridge.command.GameCommand;
import bridge.command.MoveCommand;
import bridge.valid.BridgeSizeLengthValidator;
import bridge.valid.BridgeSizeTypeValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        return inputBridgeSize();
    }

    private static int inputBridgeSize() {
        String size = Console.readLine();

        BridgeSizeTypeValidator.validateType(size);
        int bridgeSize = Integer.parseInt(size);
        BridgeSizeLengthValidator.validateSize(bridgeSize);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */

    public static MoveCommand readInitialMoving() {
        String input = Console.readLine();
        int adapt = Integer.parseInt(input);

        return MoveCommand.setCommandByNumber(adapt);
    }

    public static MoveCommand readMoving() {
        String command = Console.readLine();

        return MoveCommand.setMoveCommand(command);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}