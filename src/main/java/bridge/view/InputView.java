package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    static final String IS_NOT_NUMBER = "다리 길이는 숫자여야 합니다";

    public int readBridgeSize() {
        String bridgeSize = readLine();
        return 0;
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }

    private int strToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }
    }
}
