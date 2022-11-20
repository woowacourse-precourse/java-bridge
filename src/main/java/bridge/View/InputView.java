package bridge.View;

import bridge.Model.BridgeSizeValidator;
import bridge.Model.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String GET_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";

    private Validator validator;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(GET_BRIDGE_SIZE);
        String input = Console.readLine();
        validator = new BridgeSizeValidator();
        try{
            validator.validate(input);
        } catch(IllegalArgumentException e){
            readBridgeSize();
        }
        return Integer.parseInt(input);
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
