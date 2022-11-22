package bridge.view;

import static bridge.view.OutputView.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.domain.BridgeCellType;
import bridge.domain.GameCommand;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_LENGTH_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_COMMAND_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String NOT_INT_MESSAGE = "입력이 정수가 아닙니다. 정수를 입력해 주세요.";
    private static final String INVALID_BRIDGE_SIZE_MESSAGE = "다리 길이는 3이상 20이하의 정수여야 합니다.";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
                return getAnInt(readLine());
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private int getAnInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INT_MESSAGE);
        }
    }

    private void validateBridgeSize(int input) {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_MESSAGE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeCellType readMoving() {
        while (true) {
            try {
                System.out.println(INPUT_MOVE_MESSAGE);
                return BridgeCellType.of(readLine());
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        while (true) {
            try {
                System.out.println(INPUT_COMMAND_MESSAGE);
                return GameCommand.of(readLine());
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }
}
