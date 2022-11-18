package bridge.util;

import bridge.domain.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class MoveCommandValidator {

    private List<String> commands = new ArrayList<>(List.of("U", "D"));

    public void validate(String move){
        if(move.length() > 1 || !commands.contains(move)){
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.getMessage());
        }
    }
}
