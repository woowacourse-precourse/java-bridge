package bridge;

import bridge.enums.BridgeGameCommand;
import bridge.enums.BridgeMoving;
import bridge.enums.ErrorMessage;
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
        String size = Console.readLine();
        if (isEmptyOrNull(size) || !isNumber(size)) {
            throw new IllegalArgumentException(ErrorMessage.getMessage("INVALID_BRIDGE_SIZE"));
        }
        return Integer.parseInt(size);
    }

    private boolean isNumber(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private boolean isEmptyOrNull(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        Arrays.stream(BridgeMoving.values())
                .filter(moving -> moving.toString().equals(input))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(ErrorMessage.getMessage("INVALID_MOVING")));
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        Arrays.stream(BridgeGameCommand.values())
                .filter(gameCommand -> gameCommand.name().equals(command))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(ErrorMessage.getMessage("INVALID_GAME_COMMAND")));
        return command;
    }
}
