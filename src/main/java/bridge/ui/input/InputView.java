package bridge.ui.input;

import bridge.ui.input.dto.BridgeSize;
import bridge.ui.input.dto.MoveCommand;
import bridge.ui.input.dto.RestartCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSize readBridgeSize() {
        PlaceHolderText placeHolderText = PlaceHolderText.READ_BRIDGE_SIZE;
        System.out.println(placeHolderText.toConsolePrintFormat());

        try {
            String userInput = Console.readLine();
            return BridgeSize.from(userInput);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return this.readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MoveCommand readMoving() {
        PlaceHolderText placeHolderText = PlaceHolderText.READ_MOVE_COMMAND;
        System.out.println(placeHolderText.toConsolePrintFormat());

        try {
            String userInput = Console.readLine();
            return MoveCommand.from(userInput);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return this.readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public RestartCommand readGameCommand() {
        PlaceHolderText placeHolderText = PlaceHolderText.READ_RESTART_COMMAND;
        System.out.println(placeHolderText.toConsolePrintFormat());

        try {
            String userInput = Console.readLine();
            return RestartCommand.from(userInput);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return this.readGameCommand();
        }
    }
}
