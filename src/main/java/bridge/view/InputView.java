package bridge.view;

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
        validateInput.validateNull(bridgeInput);
        validateInput.validateNumber(bridgeInput);
        validateInput.validateBetween(bridgeInput);
        return Integer.parseInt(bridgeInput);
    }

    public int inputBridgeSize() {
        return repeatUntilSuccess(() -> {
           System.out.println("다리의 길이를 입력해주세요.");
           int bridgeSize = readBridgeSize();
           return bridgeSize;
        });
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String playerMoving = Console.readLine();
        return playerMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String restartInput = Console.readLine();
        return restartInput;
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
