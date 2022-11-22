package bridge.model;

import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.BridgeGame.move;
import static bridge.enums.DorU.UP;

public class Moving {

    private static final List<String> upLine = new ArrayList<>();
    private static final List<String> downLine = new ArrayList<>();
    private final String RIGHT = " O ";
    private final String WRONG = " X ";
    private final String BLANK = "   ";

    public void moving(String computer, String userInput) {
        upLine.add(addRightOrWrong(computer, userInput).get(0));
        downLine.add(addRightOrWrong(computer, userInput).get(1));
    }

    public static void clearMoving() {
        upLine.clear();
        downLine.clear();
    }

    public boolean checkWrong() {
        return upLine.contains(WRONG) || downLine.contains(WRONG);
    }

    public static void printMoving() {
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