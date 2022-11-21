package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.model.InputValidator;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final Logger logger = Logger.getLogger(InputView.class.getName());

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        this.requestInput(INPUT_BRIDGE_SIZE);
        return this.validateSize(readLine());
    }

    private int validateSize(String input) {
        try {
            InputValidator.isValidSize(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            this.logger.warning(getErrorSupplier(e));
            return this.readBridgeSize();
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        this.requestInput(INPUT_MOVING);
        return this.validateMoving(readLine());
    }

    private String validateMoving(String inputMoving) {
        try {
            InputValidator.isValidMoving(inputMoving);
            return inputMoving;
        } catch (IllegalArgumentException e) {
            this.logger.warning(getErrorSupplier(e));
            return this.readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        this.requestInput(INPUT_RETRY);
        return this.validateGameCommand(readLine());
    }

    private String validateGameCommand(String inputRetry) {
        try {
            InputValidator.isValidRetry(inputRetry);
            return inputRetry;
        } catch (IllegalArgumentException e) {
            this.logger.warning(getErrorSupplier(e));
            return this.readGameCommand();
        }
    }

    private void requestInput(String request) {
        System.out.println(request);
    }

    private Supplier<String> getErrorSupplier(IllegalArgumentException e) {
        return () -> {
            String message = e.getMessage();
            System.out.println(message);
            return message;
        };
    }
}
