package bridge.view;

import bridge.validator.InputViewValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String WHITE_SPACE = "\\s";
    private static final String EMPTY = "";
    private static final String PRINT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String PRINT_SELECT_MOVING_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String PRINT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            Integer bridgeSize = getBridgeSizeOrNull();
            if (bridgeSize == null) {
                continue;
            }
            return bridgeSize;
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            String movingOrNull = getMovingOrNull();
            if (movingOrNull == null) {
                continue;
            }
            return movingOrNull;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            String gameCommandOrNull = getGameCommandOrNull();
            if (gameCommandOrNull == null) {
                continue;
            }
            return gameCommandOrNull;
        }
    }

    private Integer getBridgeSizeOrNull() {
        try {
            return inputBridgeSize();
        } catch (IllegalArgumentException illegalArgumentException) {
            ErrorView.printException(illegalArgumentException);
        } catch (IllegalStateException illegalStateException) {
            ErrorView.printException(illegalStateException);
        }
        return null;
    }

    private int inputBridgeSize() {
        System.out.println();
        System.out.println(PRINT_BRIDGE_SIZE);
        String userInput = Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
        InputViewValidator.checkBridgeSizeIsNotNumber(userInput);

        int bridgeSize = Integer.parseInt(userInput);
        InputViewValidator.checkBridgeSizeNotInvalid(bridgeSize);
        return bridgeSize;
    }

    private String getMovingOrNull() {
        try {
            return inputMoving();
        } catch (IllegalArgumentException illegalArgumentException) {
            ErrorView.printException(illegalArgumentException);
        } catch (IllegalStateException illegalStateException) {
            ErrorView.printException(illegalStateException);
        }
        return null;
    }

    private String inputMoving() {
        System.out.println();
        System.out.println(PRINT_SELECT_MOVING_DIRECTION);

        String userInput = Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
        InputViewValidator.checkCommandSize(userInput);
        InputViewValidator.checkCommandUpperCase(userInput);
        InputViewValidator.checkMovingCommandCharacter(userInput);
        return userInput;
    }

    private String getGameCommandOrNull() {
        try {
            return inputGameCommand();
        } catch (IllegalArgumentException illegalArgumentException) {
            ErrorView.printException(illegalArgumentException);
        } catch (IllegalStateException illegalStateException) {
            ErrorView.printException(illegalStateException);
        }
        return null;
    }

    private String inputGameCommand() {
        System.out.println();
        System.out.println(PRINT_RETRY);

        String userInput = Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
        InputViewValidator.checkCommandSize(userInput);
        InputViewValidator.checkCommandUpperCase(userInput);
        InputViewValidator.checkRetryCommandCharacter(userInput);
        return userInput;
    }
}
