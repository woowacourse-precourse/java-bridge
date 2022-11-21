package bridge.view;

import bridge.util.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private String readAfterPrint(String output) {
        System.out.println(output);
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = readAfterPrint("다리의 길이를 입력해주세요.");
        InputValidator.bridgeSizeValidate(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = readAfterPrint("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        InputValidator.moveDirectionValidate(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = readAfterPrint("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        InputValidator.retryValidate(input);
        return input;
    }
}
