package bridge;

import java.util.List;

import static bridge.enums.DorU.*;
import static bridge.BridgeGame.move;

public class Move {

    private final String RIGHT = " O ";
    private final String WRONG = " X ";
    private final String BLANK = "   ";


    public List<String> addRightOrWrong(String computer, String userInput) {
        if (move(computer, userInput)) {
            if (userInput.equals(UP.getName())) {
                return List.of(RIGHT, BLANK);
            }
            return List.of(BLANK, RIGHT);
        }
        return wrongUpOrDown(userInput);
    }

    public List<String> wrongUpOrDown(String userInput) {
        if (userInput.equals(UP.getName())) {
            return List.of(WRONG, BLANK);
        }
        return List.of(BLANK, WRONG);
    }

}