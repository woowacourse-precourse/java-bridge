package bridge.view;

import static bridge.model.Direction.DOWN;
import static bridge.model.Direction.UP;
import static bridge.model.GameCondition.QUIT;
import static bridge.model.GameCondition.RESTART;

import bridge.model.Direction;
import bridge.model.GameCondition;
import bridge.util.NumericConverter;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String BRIDGE_LENGTH_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String MOVE_SELECT_MESSAGE = "\n이동할 칸을 선택해주세요. (위: %s, 아래: %s)";
    private static final String TRY_AGAIN_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                String input = inputBridgeSize();
                return NumericConverter.convert(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String inputBridgeSize() {
        OutputView.printMessage(BRIDGE_LENGTH_MESSAGE);
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        while (true) {
            try {
                String input = inputMoving();
                return Direction.from(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String inputMoving() {
        OutputView.printMessage(
                String.format(MOVE_SELECT_MESSAGE, UP.getDirection(), DOWN.getDirection()));
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCondition readGameCommand() {
        while (true) {
            try {
                String input = inputGameCommand();
                return GameCondition.from(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String inputGameCommand() {
        OutputView.printMessage(
                String.format(TRY_AGAIN_MESSAGE, RESTART.getCondition(), QUIT.getCondition()));
        return Console.readLine();
    }

}
