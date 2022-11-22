package bridge;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView  {

    private static Validate validate;
    public static String input(){
        return readLine();
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        int bridgeSizeInt = 0;
        while (true) {
            try {
                bridgeSizeInt = validate.validreadBridgeSize(input());
                break;
            } catch (IllegalArgumentException e) {
                ErrorMessage.INVALID_RANGE.getDesc();
            }
        }
        return bridgeSizeInt;
    }


    public InputView(){
        this.validate = new Validate();
    }
}
