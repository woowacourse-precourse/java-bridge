package bridge.view;

import bridge.model.constant.BridgePattern;
import bridge.model.constant.Command;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();

        return convertToInteger(bridgeSize);
    }

    private int convertToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력하신 값은 정수가 아닙니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgePattern readMoving() {
        String move = Console.readLine();
        return BridgePattern.searchBridgeType(move);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        String command = Console.readLine();
        return Command.searchCommand(command);
    }
}
