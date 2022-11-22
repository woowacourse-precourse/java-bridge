package view;

import camp.nextstep.edu.missionutils.Console;
import enums.PrintEnum;
import util.ValidationUtil;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(PrintEnum.PLEASE_INPUT_BRDIGE_SIZE.getValue());
        String bridgeSize = Console.readLine();
        return Integer.parseInt(ValidationUtil.isValidSize(bridgeSize));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(PrintEnum.PLEASE_CHOOSE_MOVE_SPOT.getValue());
        String moving = Console.readLine();
        return ValidationUtil.isValidMoving(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(PrintEnum.PLEASE_INPUT_RETRY_OR_NOT.getValue());
        String retrial = Console.readLine();
        return ValidationUtil.isValidRetry(retrial);
    }
}
