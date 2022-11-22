package bridge.view;

import bridge.model.GameCommandFlag;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        String bridgeSize = receiveInput();
        validateNumber(bridgeSize);
        return validateSize(bridgeSize);
    }

    public String readMoving() {
        String moving = receiveInput();
        validateMovingInput(moving);
        return moving;
    }

    public GameCommandFlag readGameCommand() {
        String gameCommand = receiveInput();
        validateGameCommand(gameCommand);
        return GameCommandFlag.toString(gameCommand);
    }

    private String receiveInput() {
        return Console.readLine();
    }

    private void validateNumber(String input) {
        if (!input.matches("^\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    private int validateSize(String input) {
        int size = Integer.parseInt(input);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return size;
    }

    private void validateMovingInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해 주세요.");
        }
    }

    private void validateGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해 주세요.");
        }
    }
}
