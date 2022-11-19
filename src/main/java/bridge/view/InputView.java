package bridge.view;

import static bridge.model.Direction.DOWN;
import static bridge.model.Direction.UP;
import static bridge.model.GameCondition.QUIT;
import static bridge.model.GameCondition.RESTART;

import bridge.model.Direction;
import bridge.model.GameCondition;
import bridge.util.NumericConverter;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                return NumericConverter.convert(inputBridgeSize());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String inputBridgeSize() {
        OutputView.printMessage("다리의 길이를 입력해주세요.");
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        while (true) {
            try {
                String input = inputMoving();
                return findMoving(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String inputMoving() {
        OutputView.printMessage(
                String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)", UP.getDirection(),
                        DOWN.getDirection()));
        return Console.readLine();
    }

    private Direction findMoving(String input) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.isMatchDirection(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("해당하는 이동 칸이 존재하지 않습니다. 입력 : %s", input)));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCondition readGameCommand() {
        while (true) {
            try {
                String input = inputGameCommand();
                return findGameCommand(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String inputGameCommand() {
        OutputView.printMessage(
                String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)", RESTART.getCondition(),
                        QUIT.getCondition()));
        return Console.readLine();
    }

    private GameCondition findGameCommand(String input) {
        return Arrays.stream(GameCondition.values())
                .filter(condition -> condition.isMatchCondition(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("해당하는 시도가 존재하지 않습니다. 입력 : %s", input)));
    }

}
