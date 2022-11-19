package bridge.view;

import bridge.domain.User;
import bridge.validate.ValidateInput;

import static bridge.util.Constants.OutputViewConstants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static StringBuilder TOP_BRIDGE = null;
    private static StringBuilder BOTTOM_BRIDGE = null;

    public static void enter() {
        System.out.println();
    }

    public static void printStartBridgeGame() {
        System.out.println(START_BRIDGE_GAME);
        OutputView.enter();
        System.out.println(INPUT_BRIDGE_LENGTH);
    }

    public static String printSelectMovingBlock() {
        System.out.println(INPUT_SELECT_MOVE_BLOCK);
        String movingBlock = InputView.readMoving();
        ValidateInput.validateMovingBlock(movingBlock);
        return movingBlock;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(boolean isSuccess, User user, int step) {
        TOP_BRIDGE = new StringBuilder().append(BRIDGE_START);
        BOTTOM_BRIDGE = new StringBuilder().append(BRIDGE_START);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
