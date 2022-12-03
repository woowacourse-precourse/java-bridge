package bridge.valid;

import bridge.Constant;

public class ValidateMove {
    public String validateMove(String move){
        validate(move);
        return move;
    }

    private void validate(String move){
        if(validateLength(move)){
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE+" 입력값은 한글자이어야 합니다.");
        }
        if(!validateExpectedValue(move)){
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE+" 입력값은 U 또는 D 중 하나이어야 합니다.");
        }
    }

    private boolean validateLength(String move){
        return move.length()!=1;
    }

    private boolean validateExpectedValue(String move){
        if(move.equals("U")||move.equals("D")){
            return true;
        }
        return false;
    }
}
