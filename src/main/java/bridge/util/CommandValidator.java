package bridge.util;

import bridge.domain.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class CommandValidator {

    private final List<String> moveCommands = new ArrayList<>(List.of("U", "D"));
    private final List<String> retryCommands = new ArrayList<>(List.of("R", "Q"));

    public void validate(String move){
        if(move.length() > 1 || !moveCommands.contains(move)){
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.getMessage());
        }
    }

    public void retryValidate(String retry){
        if(retry.length() > 1 || !retryCommands.contains(retry)){
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.getMessage());
        }
    }
}
