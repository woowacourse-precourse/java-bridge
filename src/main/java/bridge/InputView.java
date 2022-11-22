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
        System.out.println(MSG_GET_LENGTH);
        while(true){
            try{
                int size = validateSize(readLine());
                return size;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
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
            throw new IllegalArgumentException(ERROR_INT, e);
        }
    }

    private void validateRange(int size){
        if (size < 3){
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
        if (size > 20){
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = "";
        while(true){
            try{
                moving = readLine();
                validateMoving(moving);
                return moving;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean validateMoving(String input){
        if(input.equals("U") || input.equals("D")){
            return true;
        }
        throw new IllegalArgumentException(ERROR_MOVE);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = "";
        while(true){
            try{
                command = readLine();
                validateCommand(command);
                return command;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }


    public boolean validateCommand(String input){
        if(input.equals("R") || input.equals("Q")){
            return true;
        }
        throw new IllegalArgumentException(ERROR_RETRY);
    }
}
