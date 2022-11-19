package view;

import camp.nextstep.edu.missionutils.Console;
import util.ValidationUtil;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    final static String INPUT_BRDIGE_SIZE_PLEASE = "다리의 길이를 입력해주세요.";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRDIGE_SIZE_PLEASE);
        int bridgeSize = Integer.parseInt(Console.readLine());
        return ValidationUtil.isValidSize(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
