package bridge.view;

import bridge.constants.Command;
import bridge.domain.ValidateInput;
import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final ValidateInput validateInput;

    public InputView(ValidateInput validateInput) {
        this.validateInput = validateInput;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeInput = Console.readLine();
        validateInput.validateNumber(bridgeInput);
        validateInput.validateBetween(bridgeInput);
        return Integer.parseInt(bridgeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String playerMoving = Console.readLine();
        validateInput.validateUpAndDownCharacter(playerMoving);
        return playerMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String restartInput = Console.readLine();
        validateInput.validateRestartAndEndCharacter(restartInput);
        return restartInput;
    }

    public int inputBridgeSize() {
        return repeatUntilSuccess(() -> {
            System.out.println("다리의 길이를 입력해주세요.");
            return readBridgeSize();
        });
    }

    public String inputMoving() {
        return repeatUntilSuccess(() -> {
            System.out.printf("이동할 칸을 선택해주세요. (위: %s, 아래: %s)%n",
                    Command.UP.relevantCommand(), Command.DOWN.relevantCommand());
            return readMoving();
        });
    }

    public String inputGameCommand() {
        return repeatUntilSuccess(() -> {
            System.out.printf("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)%n",
                    Command.RE_START.relevantCommand(), Command.END.relevantCommand());
            return readGameCommand();
        });
    }

    private <T> T repeatUntilSuccess(Supplier<T> callback) {
        while (true) {
            try {
                return callback.get();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
