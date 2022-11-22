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
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String moving ="";
        while(true){
            try{
                moving =validate.validateMoving(input());
                break;
            }catch (IllegalArgumentException e){
                ErrorMessage.INVALID_MOVING.getDesc();
            }
        }
        return moving;
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String gameCommand = "";
        while (true) {
            try {
                gameCommand = validate.validateGameCommand(input());
                System.out.println(gameCommand);
                break;
            } catch (IllegalArgumentException e) {
                ErrorMessage.INVALID_RETRY.getDesc();
            }
        }
        return gameCommand;
    }
    public InputView(){
        this.validate = new Validate();
    }
}
