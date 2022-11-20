package bridge.view;

import bridge.model.BridgeType;
import bridge.model.ContinueType;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        return convertToInt(input);
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값을 정수로 변환할 수 없습니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeType readMoving() {
        String input = Console.readLine();
        return BridgeType.searchBridgeByCommand(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public ContinueType readGameCommand() {
        String input = Console.readLine();
        return ContinueType.searchContinueTypeByCommand(input);
    }
}
