package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.constant.Constant.LINE;
import static bridge.view.validation.InputValidation.checkValidation;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private boolean validate;
    private String input;

    public InputView() {
        resetField();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (validate) {
            System.out.println(LINE + "다리의 길이를 입력해주세요.");
            input = Console.readLine();
            validate = checkValidation(input, "readBridgeSize");
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        resetField();
        while (validate) {
            System.out.println(LINE + "이동할 칸을 선택해주세요. (위: U, 아래: D)");
            input = Console.readLine();
            validate = checkValidation(input, "readMoving");
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        resetField();
        while (validate) {
            System.out.println(LINE + "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            input = Console.readLine();
            validate = checkValidation(input, "readGameCommand");
        }
        return input;
    }

    private void resetField() {
        this.validate = true;
        this.input = "";
    }
}
