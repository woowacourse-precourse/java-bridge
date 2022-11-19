package bridge.view;

import bridge.domain.User;
import bridge.validate.ValidateInput;

import java.util.Objects;

import static bridge.util.Constants.ExceptionConstants.ERROR_TITLE;
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
        printProcessResult(isSuccess, user, step);
    }

    private static void printProcessResult(boolean isSuccess, User user, int step) {
        for (int i = 0; i < step; i++) {
            String block = user.getPastResult().get(i);
            appendByPastBlock(block);
        }
        appendByCurrentBlock(isSuccess, user);
        finalPrintTask();
        enter();
    }

    private static void appendByPastBlock(String block) {
        if (Objects.equals(block, UP)) {
            TOP_BRIDGE.append(ZERO_AND_STICK);
            BOTTOM_BRIDGE.append(STICK);
        }

        if (Objects.equals(block, DOWN)) {
            TOP_BRIDGE.append(STICK);
            BOTTOM_BRIDGE.append(ZERO_AND_STICK);
        }
    }

    private static void appendByCurrentBlock(boolean isSuccess, User user) {
        if (isSuccess) {
            appendBySuccessCurrentBlock(user);
        }
        if (!isSuccess) {
            appendByFailedCurrentBlock(user);
        }
    }

    private static void appendBySuccessCurrentBlock(User user) {
        if (user.currentBlock == 0) {
            TOP_BRIDGE.append(ZERO);
            BOTTOM_BRIDGE.append(EMPTY);
        }

        if (user.currentBlock == 1) {
            TOP_BRIDGE.append(EMPTY);
            BOTTOM_BRIDGE.append(ZERO);
        }
    }

    private static void appendByFailedCurrentBlock(User user) {
        if (user.currentBlock == 0) {
            TOP_BRIDGE.append(X);
            BOTTOM_BRIDGE.append(EMPTY);
        }

        if (user.currentBlock == 1) {
            TOP_BRIDGE.append(EMPTY);
            BOTTOM_BRIDGE.append(X);
        }
    }

    private static void finalPrintTask() {
        TOP_BRIDGE.append(BRIDGE_END);
        BOTTOM_BRIDGE.append(BRIDGE_END);
        System.out.println(TOP_BRIDGE.toString());
        System.out.println(BOTTOM_BRIDGE.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(boolean isGameClear, int retryCount) {
        printGameClearWhether(isGameClear);
        printRetryCount(retryCount);
    }

    private static void printGameClearWhether(boolean isGameClear) {
        if (isGameClear) {
            System.out.println(WHETHER_GAME_CLEAR + SUCCESS);
        }

        if (!isGameClear) {
            System.out.println(WHETHER_GAME_CLEAR + FAIL);
        }
    }

    public static void printRetryCount(int retryCount) {
        System.out.println(RETRY_COUNT + retryCount);
    }

    public static void printGameResult() {
        System.out.println(GAME_RESULT);
        printGameResultTask();
    }

    private static void printGameResultTask() {
        System.out.println(TOP_BRIDGE.toString());
        System.out.println(BOTTOM_BRIDGE.toString());
    }

    public static void printError(String message) {
        System.out.println(ERROR_TITLE + message);
    }
}
