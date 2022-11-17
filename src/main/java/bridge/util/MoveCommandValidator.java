package bridge.util;

import java.util.ArrayList;
import java.util.List;

public class MoveCommandValidator {

    private List<String> commands = new ArrayList<>(List.of("U", "D"));

    public void validate(String move){
        if(move.length() > 1 || !commands.contains(move)){
            throw new IllegalArgumentException("올바른 값을 입력해주세요");
        }
    }
}
