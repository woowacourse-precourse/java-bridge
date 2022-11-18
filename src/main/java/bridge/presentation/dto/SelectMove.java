package bridge.presentation.dto;

import bridge.support.Validator;

public class SelectMove {
    private final String move;
    public SelectMove(String input){
        validate(input);
        move=input;
    }
    private void validate(String target){
        Validator.checkMoveAlphabet(target);
    }
    public String getMove() {
        return move;
    }
}
