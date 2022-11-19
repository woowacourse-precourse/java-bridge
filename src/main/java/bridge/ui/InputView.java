package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(" 숫자를 입력해 주세요");
        }
    }

    public String readMoving() {
        String input = Console.readLine();
        checkUpDown(input);
        return input;
    }

    public String readGameCommand() {
        String input = Console.readLine();
        checkRestartStop(input);
        return input;
    }

    private void checkUpDown(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(" U 또는 D 를 입력해 주세요");
        }
    }

    private void checkRestartStop(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(" R 또는 Q 를 입력해 주세요");
        }
    }
}
