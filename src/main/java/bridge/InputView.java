package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING_POSITION_MESSAGE = "이동할 칸을 선택해주세요. (위: %s, 아래: %s)%n";
    private static final String INPUT_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)%n";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        String input = getInput();
        validateInteger(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String upBridge, String downBridge) {
        System.out.printf(INPUT_MOVING_POSITION_MESSAGE, upBridge, downBridge);
        return getInput();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String retry, String end) {
        System.out.printf(INPUT_GAME_COMMAND_MESSAGE, retry, end);
        return getInput();
    }


    private String getInput() {
        String input = Console.readLine().trim();
        validateNotEmpty(input);
        return input;
    }

    private void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
    }

}
