package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final static List<String> POSSIBLE_COMMAND = List.of("R", "Q");

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        validate(command);
        return command;
    }

    private void validate(String command) {
        if (!POSSIBLE_COMMAND.contains(command)) {
            throw new IllegalArgumentException("[ERROR] 재시도 'R' 혹은 종료 'Q' 만 입력할 수 있습니다.");
        }
    }
}
