package bridge.ui;

import bridge.domain.GameCommand;
import bridge.domain.MoveCommand;
import bridge.exception.BridgeGameError;
import bridge.exception.BridgeSizeException;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        System.out.println();

        validationInteger(input);
        int bridgeSize = Integer.parseInt(input);
        validationBridgeSize(bridgeSize);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static MoveCommand readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();

        return MoveCommand.setCommand(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static GameCommand readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();

        return GameCommand.setCommand(input);
    }

    private static void validationInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BridgeSizeException(BridgeGameError.BRIDGE_SIZE_NOT_INTEGER);
        }
    }

    private static void validationBridgeSize(int bridgeSize) {
        if (bridgeSize > 20 || bridgeSize < 3) {
            throw new BridgeSizeException(BridgeGameError.BRIDGE_SIZE_EXCLUDE_RANGE);
        }
    }
}
