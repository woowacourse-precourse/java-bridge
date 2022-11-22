package bridge.View;

import static bridge.Constant.Command.*;
import static bridge.Constant.Message.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        int size = 0;
        while(true){
            try{
                size = validateSize(readLine());
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
        if (size < SIZE_MIN){
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
        if (size > SIZE_MAX){
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }


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
        if(input.equals(UP) || input.equals(DOWN)){
            return true;
        }
        throw new IllegalArgumentException(ERROR_MOVE);
    }


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
        if(input.equals(RETRY) || input.equals(QUIT)){
            return true;
        }
        throw new IllegalArgumentException(ERROR_RETRY);
    }
}
