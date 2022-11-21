package bridge.view;

import camp.nextstep.edu.missionutils.Console;

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

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = parser.parseNumber(readLine());
        validator.validateBridgeSize(bridgeSize);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = readLine();
        validator.validateMoving(moving);

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = readLine();
        validator.validateGameCommand(gameCommand);

        return gameCommand;
    }
}
