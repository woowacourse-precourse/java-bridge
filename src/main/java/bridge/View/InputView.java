package bridge.View;

import bridge.Model.BridgeSizeValidator;
import bridge.Model.GameCommandValidator;
import bridge.Model.MovingCommandValidator;
import bridge.Model.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String GET_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String GET_MOVING_COMMAND = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GET_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

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
            return readBridgeSize();
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
            return readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GET_GAME_COMMAND);
        String input = Console.readLine();
        validator = new GameCommandValidator();
        try{
            validator.validate(input);
        }catch(IllegalArgumentException e){
            return readGameCommand();
        }
        return input;
    }
}
