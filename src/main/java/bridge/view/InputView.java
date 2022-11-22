package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public Integer readBridgeSize() {
        String input = Console.readLine();

        Integer bridgeSize = bridgeSizeParseInt(input);
        bridgeSize = validateSizeLimit(bridgeSize);

        return bridgeSize;
    }

    private Integer validateSizeLimit(Integer bridgeSize) {
        try {
            checkBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private void checkBridgeSize(Integer bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private Integer bridgeSizeParseInt(String input) {
        Integer bridgeSize = null;
        try {
            bridgeSize = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자만 입력해주세요.");
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();

        input = validateMovingInputLength(input);
        String validInput = validateMovingSpace(input);
        return validInput;
    }

    private String validateMovingInputLength(String input) {
        try {
            checkMovingInputLength(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private void checkMovingInputLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 입력 가능한 길이를 초과하였습니다.");
        }
    }

    private String validateMovingSpace(String input) {
        try {
            checkMovingSpace(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private void checkMovingSpace(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("[ERROR] \"U\" 또는 \"D\"만 입력 가능합니다. ");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return Console.readLine();
    }
}
