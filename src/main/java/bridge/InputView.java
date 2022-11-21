package bridge;

import static bridge.Message.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size = 0;
        try{
            size = validateSize(readLine());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            size = readBridgeSize();
        }
        return size;
    }

    public int validateSize(String input){
        int size = string2int(input);
        validateRange(size);
        return size;
    }

    private int string2int(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INT.getMessage(), e);
        }
    }

    private void validateRange(int size){
        if (size < 3){
            throw new IllegalArgumentException(ERROR_LENGTH.getMessage());
        }
        if (size > 20){
            throw new IllegalArgumentException(ERROR_LENGTH.getMessage());
        }
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
