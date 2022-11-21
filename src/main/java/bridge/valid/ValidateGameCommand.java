package bridge.valid;

import bridge.Constant;

public class ValidateGameCommand {
    public String validateGameCommand(String inputCommand){
        validate(inputCommand);
        return inputCommand;
    }

    private void validate(String move){
        if(validateLength(move)){
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE+" 입력값은 한글자이어야 합니다.");
        }
        if(!validateExpectedValue(move)){
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE+" 입력값은 R 또는 Q 중 하나이어야 합니다.");
        }
    }

    private boolean validateLength(String move){
        return move.length()!=1;
    }

    private boolean validateExpectedValue(String move){
        if(move.equals("R")||move.equals("Q")){
            return true;
        }
        return false;
    }
}
