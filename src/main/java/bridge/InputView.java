package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        String input = Console.readLine();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }

    public void validateBridgeSize(String input) {
        if (!input.matches("^[0-9][1,2]") && !isInRange(Integer.parseInt(input))) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20사이의 숫자여야 합니다.");
        }
    }

    public boolean isInRange(int input) {
        if (input < 3 && input > 20) {
            return false;
        }
        return true;
    }
}
