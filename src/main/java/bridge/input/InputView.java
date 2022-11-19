package bridge.input;

import camp.nextstep.edu.missionutils.Console;

import static bridge.input.InputString.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_LENGTH_INPUT);
        int inputLength;
        try{
            inputLength = Integer.parseInt(Console.readLine());
        }catch (Exception e){
            throw new IllegalArgumentException(ERROR_NO_NUMBER_INPUT);
        }
        if(inputLength < 3 || inputLength > 20 ) {
            throw new IllegalArgumentException(ERROR_NOT_IN_RANGE);
        }
        return inputLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_INPUT);
        String input = Console.readLine();
        if(input != "U" || input != "D"){
            throw new IllegalArgumentException(ERROR_MOVE_INPUT);
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_INPUT);
        String input = Console.readLine();
        if(input != "R" || input != "Q"){
            throw new IllegalArgumentException(ERROR_RESTART_INPUT);
        }
        return input;
    }
}
