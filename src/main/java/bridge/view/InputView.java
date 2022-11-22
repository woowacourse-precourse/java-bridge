package bridge.view;

import bridge.io.ConsoleReader;
import bridge.domain.BridgeLength;
import bridge.domain.MovingCommand;
import bridge.domain.RetryCommand;

public class InputView extends View {

    private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String REQUEST_MOVING_COMMAND = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String REQUEST_RETRY_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public BridgeLength readBridgeSize() {
        while (true) {
            print(REQUEST_BRIDGE_SIZE);
            try {
                int input = ConsoleReader.readInt();
                return new BridgeLength(input);
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    public MovingCommand readMoving() {
        while (true) {
            print(REQUEST_MOVING_COMMAND);
            try {
                String input = ConsoleReader.readString();
                return MovingCommand.nameOf(input);
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    public RetryCommand readGameCommand() {
        while (true) {
            print(REQUEST_RETRY_COMMAND);
            try {
                String input = ConsoleReader.readString();
                return RetryCommand.nameOf(input);
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }
}
