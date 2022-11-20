package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        printGuideMessage(OutputMessage.BRIDGE_SIZE);
        String input = Console.readLine();
        validateSizeForm(input);
        return Integer.parseInt(input);
    }

    private void validateSizeForm(String input) {
        if (!input.matches("\\d{1,2}")) {
            throw new IllegalArgumentException("[ERROR] 두 자리 이하의 숫자만 입력 가능합니다.");
        }
    }

    public String readMoving() {
        printGuideMessage(OutputMessage.MOVE);
        return Console.readLine();
    }

    public String readGameCommand() {
        printGuideMessage(OutputMessage.RESTART);
        return Console.readLine();
    }

    private void printGuideMessage(OutputMessage outputMessage) {
        System.out.print(outputMessage.getMessage());
    }
}
