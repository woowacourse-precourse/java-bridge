package bridge.utils.console;

import static bridge.utils.message.ErrorMessagesUtil.MOVING;
import static bridge.utils.message.ErrorMessagesUtil.NOT_BLANK;
import static bridge.utils.message.ErrorMessagesUtil.ONLY_NUMBERS;
import static bridge.utils.message.ErrorMessagesUtil.RETRY_COMMAND;
import static bridge.utils.message.ErrorMessagesUtil.SIZE_OUT_OF_RANGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import org.assertj.core.util.Strings;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();
        validateBridgeSize(size);

        return toInt(size);
    }

    private void validateBridgeSize(String size) {
        if (Strings.isNullOrEmpty(size)) {
            throw new IllegalArgumentException(NOT_BLANK.getMessage());
        }

        if (Pattern.matches(".*\\s.*", size)) { // 공백을 입력하면 예외 발생
            throw new IllegalArgumentException(NOT_BLANK.getMessage());
        }

        if (Pattern.matches(".*\\D.*", size)) { // 문자가 섞이면 예외 발생
            throw new IllegalArgumentException(ONLY_NUMBERS.getMessage());
        }

        if (size.length() >= 3) {
            throw new IllegalArgumentException(SIZE_OUT_OF_RANGE.getMessage());
        }

        if (Integer.parseInt(size) < 3 || Integer.parseInt(size) > 20) {
            throw new IllegalArgumentException(SIZE_OUT_OF_RANGE.getMessage());
        }
    }

    private int toInt(String size) {
        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        validateMove(move);

        return move;
    }

    private void validateMove(String move) {
        if (move.equals("U") || move.equals("D")) {
            return;
        }
        throw new IllegalArgumentException(MOVING.getMessage());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        validateCommand(command);

        return command;
    }

    private void validateCommand(String command) {
        if (command.equals("R") || command.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException(RETRY_COMMAND.getMessage());
    }
}
