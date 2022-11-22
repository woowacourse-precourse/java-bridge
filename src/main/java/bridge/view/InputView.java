package bridge.view;

import static bridge.view.GameMsg.GET_LENGTH_MSG;
import static bridge.view.GameMsg.GET_WAY_MSG;
import static bridge.view.GameMsg.RETRY_MSG;
import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.model.Validator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(GET_LENGTH_MSG.getMsg());
        String size = input();
        Validator.validateNumeric(size);
        System.out.println();
        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(GET_WAY_MSG.getMsg());
        return input();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_MSG.getMsg());
        return input();
    }

    private String input() {
        return readLine().strip();
    }
}
