package bridge.view;

import bridge.util.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String ASK_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String ASK_NEXT_STEP = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String ASK_RETRY_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private String readString() {
        String input = Console.readLine().trim();
        return inputToUpperCase(input);
    }

    private String inputToUpperCase(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
            char upperCase = Character.toUpperCase(input.charAt(inputIndex));
            stringBuilder.append(upperCase);
        }
        return stringBuilder.toString();
    }

    public int readBridgeSize() {
        System.out.println(ASK_BRIDGE_SIZE);
        String input = readString();
        Validator.validateNumberType(input);
        int inputNumber = Integer.parseInt(input);
        Validator.validateBridgeSize(inputNumber);
        System.out.println();
        return inputNumber;
    }

    public String readMoving() {
        System.out.println(ASK_NEXT_STEP);
        String input = readString();
        Validator.validateUpDown(input);
        return input;
    }

    public String readGameCommand() {
        System.out.println(ASK_RETRY_GAME);
        String input = readString();
        Validator.validateRetryQuit(input);
        return input;
    }
}
