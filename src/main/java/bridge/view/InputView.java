package bridge.view;

import static bridge.domain.BridgeGame.DOWN_BRIDGE;
import static bridge.domain.BridgeGame.UP_BRIDGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final InputValidator validator;
    private final InputParser parser;

    public InputView(InputValidator validator, InputParser parser) {
        this.validator = validator;
        this.parser = parser;
    }

    private String readLine() {
        return Console.readLine().trim();
    }

    private void println(String format, Object... args) {
        System.out.printf(format + "\n", args);
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return repeatInputUntilSuccess(() -> {
            println("다리의 길이를 입력해주세요.");

            int bridgeSize = parser.parseNumber(readLine());
            validator.validateBridgeSize(bridgeSize);

            return bridgeSize;
        });
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return repeatInputUntilSuccess(() -> {
            println("이동할 칸을 선택해주세요. (위: %s, 아래: %s)", UP_BRIDGE, DOWN_BRIDGE);

            String moving = readLine();
            validator.validateMoving(moving);

            return moving;
        });
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        final String QUIT = "Q";
        final String RETRY = "R";

        return repeatInputUntilSuccess(() -> {
            println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)", RETRY, QUIT);

            String gameCommand = readLine();
            validator.validateGameCommand(gameCommand);
            return gameCommand;
        });
    }

    private <T> T repeatInputUntilSuccess(Supplier<T> callback) {
        while (true) {
            try {
                return callback.get();
            } catch (IllegalArgumentException e) {
                println("[ERROR] %s", e.getMessage());
            }
        }
    }
}
