package bridge.view;

import bridge.model.BridgeValidator;
import bridge.model.Command;
import bridge.model.Direction;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
        int bridgeSize = readNumber();
        BridgeValidator.validateBridgeSize(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String direction = readAndTrim();
        return Direction.find(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = readAndTrim();
        return Command.find(command);
    }

    private static int readNumber() {
        try {
            return Integer.parseInt(readAndTrim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 입력되었습니다. 숫자를 입력해주세요.");
        }
    }

    private static String readAndTrim() {
        return Console.readLine().trim();
    }
}
