package view;

import bridge.BridgeGameMark;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int MAX_BRIDGE_SIZE = 20;
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final String OVER_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String IS_DIGIT_ERROR_MESSAGE = "[ERROR] 다리 길이는 숫자만 입력 가능합니다.";
    private static final String EMPTY_ERROR_MESSAGE = "[ERROR] 공백은 입력할 수 없습니다.";
    private static final String UP_AND_DOWN_ERROR_MESSAGE = "[ERROR] 이동하는 칸은 U 혹은 D 으로만 선택 가능합니다.";
    private static final String RESTART_OR_QUIT_ERROR_MESSAGE = "[ERROR] 게임 종료 후에는 R 또는 Q만 입력 가능합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                String bridgeSize = Console.readLine();
                validateInputBridgeSize(bridgeSize);
                return Integer.parseInt(bridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                String moving = Console.readLine();
                validateInputMoving(moving);
                return moving;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                String doRestart = Console.readLine();
                validateInputGameCommand(doRestart);
                return doRestart;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateInputBridgeSize(String bridgeSize) {
        validateIsDigit(bridgeSize);
        validateOverSize(Integer.parseInt(bridgeSize));
        validateIsEmpty(bridgeSize);
    }

    public void validateInputMoving(String moving) {
        validateUpOrDown(moving);
        validateIsEmpty(moving);
    }

    public void validateInputGameCommand(String doRestart) {
        validateRestartOrQuit(doRestart);
        validateIsEmpty(doRestart);
    }

    public void validateOverSize(int bridgeSize) {
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(OVER_SIZE_ERROR_MESSAGE);
        }
    }

    public void validateIsDigit(String bridgeSize) {
        for (int i = 0; i < bridgeSize.length(); i++) {
            if (!Character.isDigit(bridgeSize.charAt(i))) {
                throw new IllegalArgumentException(IS_DIGIT_ERROR_MESSAGE);
            }
        }
    }

    public void validateIsEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    public void validateUpOrDown(String moving) {
        if (!moving.equals(BridgeGameMark.UP_MARK.getMark())
                && !moving.equals(BridgeGameMark.DOWN_MARK.getMark())) {
            throw new IllegalArgumentException(UP_AND_DOWN_ERROR_MESSAGE);
        }
    }

    public void validateRestartOrQuit(String doRestart) {
        if (!doRestart.equals(BridgeGameMark.RETRY_MARK.getMark())
                && !doRestart.equals(BridgeGameMark.QUIT_MARK.getMark())) {
            throw new IllegalArgumentException(RESTART_OR_QUIT_ERROR_MESSAGE);
        }
    }
}
