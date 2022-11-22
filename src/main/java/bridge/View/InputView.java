package bridge.View;

import bridge.Constants;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Constants.BRIDGE_SIZE_REQUEST_MESSAGE);

        return validateBridgeSize(Console.readLine());
    }

    private int validateBridgeSize(String input){
        try{
            return validateBridgeSizeRange(Integer.parseInt(input));
        }catch (IllegalArgumentException e){
            System.out.println(getBridgeSizeExceptionMessage(e));

            return readBridgeSize();
        }
    }

    private int validateBridgeSizeRange(int bridgeSize){
        if(bridgeSize<3 || bridgeSize>20){
            throw new IllegalArgumentException(Constants.BRIDGE_SIZE_RANGE_ERROR_MESSAGE);
        }

        return bridgeSize;
    }

    private String getBridgeSizeExceptionMessage(IllegalArgumentException e){
        if(e.getClass().equals(NumberFormatException.class)){
            return Constants.BRIDGE_SIZE_NUMBER_FORMAT_ERROR_MESSAGE;
        }

        return e.getMessage();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Constants.MOVING_REQUEST_MESSAGE);

        return validateMoving(Console.readLine());
    }

    private String validateMoving(String input){
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Constants.RESTART_REQUEST_MESSAGE);

        return validateGameCommand(Console.readLine());
    }

    private String validateGameCommand(String input){
        return input;
    }
}
