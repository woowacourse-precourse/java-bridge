package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String pleaseInputBridgeSize = "다리의 길이를 입력해주세요.";
        System.out.println(pleaseInputBridgeSize);

        String input = Console.readLine();
        InputViewValidation.validateIsInteger(input);
        InputViewValidation.validateIsInRange(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String pleaseInputMoving = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
        System.out.println(pleaseInputMoving);

        String input = Console.readLine();
        InputViewValidation.validateIsUorD(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String pleaseInputRetryOrEnd = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
        System.out.println(pleaseInputRetryOrEnd);

        String input = Console.readLine();
        InputViewValidation.validateIsRorQ(input);
        return input;
    }
}
