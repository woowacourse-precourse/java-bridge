package bridge;

import bridge.command.GameCommand;
import bridge.command.MoveCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    public static void run() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    private static int inputBridgeSize() {
        try {
            return InputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(SystemMessage.SYSTEM_MESSAGE_INPUT_BRIDGE_SIZE);
        }
        return inputBridgeSize();
    }

    private static MoveCommand inputMoveCommand() {
        try {
            return InputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println((SystemMessage.SYSTEM_MESSAGE_INPUT_MOVING));
        }
        return inputMoveCommand();
    }
}
