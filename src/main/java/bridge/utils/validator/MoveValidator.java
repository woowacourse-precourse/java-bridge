package bridge.utils.validator;

import static bridge.utils.Constant.*;

import bridge.utils.Util;

public class MoveValidator {

    private static final String NOT_RANGE_STATE = "유효한 이동이 아닙니다.";
    private final String move;

    public MoveValidator(String move){
        this.move = move;
        isValidMove();
    }

    private void isValidMove(){
        if (!this.move.equals(UP) && !this.move.equals(DOWN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_RANGE_STATE);
        }
    }


}
