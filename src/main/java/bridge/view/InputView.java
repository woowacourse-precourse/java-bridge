package bridge.view;

import bridge.exception.ErrorMsg;
import camp.nextstep.edu.missionutils.Console;

import java.util.function.Supplier;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.GET_BRIDGE_LENGTH);
        int size = convertSize(Console.readLine());
        validateBridgeSize(size);
        return size;
    }

    public  <T> T tryReadingInput (Supplier<T> function){
        while(true){
            try{
                return function.get();
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int convertSize(String size){
        try{return Integer.parseInt(size);}
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMsg.NOT_NUMBER.toString());
        }
    }

    private void validateBridgeSize(int size){
        if (size < 3 || size > 20)
            throw new IllegalArgumentException(ErrorMsg.WRONG_BRIDGE_SIZE.toString());
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
