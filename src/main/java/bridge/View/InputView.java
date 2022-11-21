package bridge.View;

import bridge.Controller.BridgeSizeValidator;
import bridge.Controller.MovingCommandValidator;
import bridge.Controller.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String GET_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String GET_MOVING_COMMAND = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

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
        System.out.println(GET_MOVING_COMMAND);
        String input = Console.readLine();
        validator = new MovingCommandValidator();
        try{
            validator.validate(input);
        }catch(IllegalArgumentException e){
            readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
