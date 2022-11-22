package bridge.User;

import bridge.Enums.Error;

public class ValidUserInput {

    // 값을 하나씩 입력할 때의 Validation
    public static String checkInputUpAndDown(String moving){
        if (!moving.equals("U") && !moving.equals("D")){
            Error.MOVE_ERROR.error();
            return moving;
        }
        return moving;
    }

    // GameOver됐을 때의 command 입력 Validation
    public static String commandIsRorQ(String command){
        if (!command.equals("R") && !command.equals("Q")){
            Error.COMMAND_ERROR.error();
        }
        return command;
    }
}
