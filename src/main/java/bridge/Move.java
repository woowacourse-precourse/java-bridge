package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.enums.DorU.*;
import static bridge.BridgeGame.move;

public class Move {

    private List<String> upLine = new ArrayList<>();
    private List<String> downLine = new ArrayList<>();
    private final String RIGHT = " O ";
    private final String WRONG = " X ";
    private final String BLANK = "   ";

    public void moving(String computer, String userInput) {
        upLine.add(addRightOrWrong(computer, userInput).get(0));
        downLine.add(addRightOrWrong(computer, userInput).get(1));
    }

    public void clearMoving() {
        upLine.clear();
        downLine.clear();
    }

    public boolean checkWrong() {
        return !upLine.contains(WRONG) && !downLine.contains(WRONG);
    }

    public void printMoving() {
        OutputView.printMap(upLine, downLine);
    }

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