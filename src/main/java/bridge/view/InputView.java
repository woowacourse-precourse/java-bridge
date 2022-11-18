package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.domain.BridgeCellType;
import bridge.domain.GameCommand;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String NOT_INT_MESSAGE = "입력이 정수가 아닙니다. 정수를 입력해 주세요.";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
        String input = readLine();
        return getAnInt(input);
    }

    private int getAnInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INT_MESSAGE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeCellType readMoving() {
        System.out.println(INPUT_MOVE_MESSAGE);
        return BridgeCellType.of(readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        System.out.println(INPUT_COMMAND_MESSAGE);
        return GameCommand.of(readLine());
    }
}
