package bridge.view;

import bridge.domain.Tile;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_SIZE_INFO_MESSAGE = "다리의 길이를 입력해 주세요.";
    private static final String INPUT_MOVING_DIRECTION_INFO_MESSAGE_FORMAT = "이동할 칸을 선택해 주세요. (위: %s, 아래: %s)";
    private static final String INPUT_GAME_RETRY_MESSAGE_FORMAT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료 : %s)";

    private static final String POSITIVE_NUMBER_INPUT_ERROR_MESSAGE = "[ERROR] 양의 숫자를 입력하여야 합니다.";
    private static final String GAME_RETRY_INPUT_ERROR_MESSAGE_FORMAT = "[ERROR] %s 또는 %s를 입력하여야 합니다.";

    private static final String POSITIVE_NUMBER_REGEX = "^[1-9]+\\d*$";
    private static final String GAME_RETRY_INPUT_REGEX_FORMAT = "^[%s%s]$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printInputBridgeSizeInfoMessage();
        String bridgeSizeInput = Console.readLine();
        validateIsPositiveNumber(bridgeSizeInput);
        return Integer.parseInt(bridgeSizeInput);
    }

    private void printInputBridgeSizeInfoMessage() {
        System.out.println(INPUT_BRIDGE_SIZE_INFO_MESSAGE);
    }

    private void validateIsPositiveNumber(String input) {
        if (input.matches(POSITIVE_NUMBER_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(POSITIVE_NUMBER_INPUT_ERROR_MESSAGE);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        printInputMovingDirectionInfoMessage();
        String input = Console.readLine();
        return input;
    }

    private void printInputMovingDirectionInfoMessage() {
        System.out.println(String.format(INPUT_MOVING_DIRECTION_INFO_MESSAGE_FORMAT,
                Tile.UP.getDirectionSign(), Tile.DOWN.getDirectionSign()));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String retryInputFormat, String quitInputFormat) {
        printGameRetryMessage(retryInputFormat, quitInputFormat);
        String retryInput = Console.readLine();
        validateRetryInput(retryInput, retryInputFormat, quitInputFormat);
        return retryInput;
    }

    private void printGameRetryMessage(String retryInputFormat, String quitInputFormat) {
        System.out.println(String.format(INPUT_GAME_RETRY_MESSAGE_FORMAT, retryInputFormat, quitInputFormat));
    }

    private void validateRetryInput(String input, String retryInputFormat, String quitInputFormat) {
        if (input.matches(String.format(GAME_RETRY_INPUT_REGEX_FORMAT, retryInputFormat, quitInputFormat))) {
            return;
        }
        throw new IllegalArgumentException(String
                .format(GAME_RETRY_INPUT_ERROR_MESSAGE_FORMAT, retryInputFormat, quitInputFormat));
    }

}
