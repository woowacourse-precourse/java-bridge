package bridge.view.input;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        System.out.println();

        return convertBridgeSize(input);
    }

    private int convertBridgeSize(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]", e);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        System.out.println();

        validateMoving(input);

        return input;
    }

    private void validateMoving(String input) {
        if (input.equals("U") || input.equals("D")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
