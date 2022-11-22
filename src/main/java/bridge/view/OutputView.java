package bridge.view;

import bridge.constants.ConstMessage;
import bridge.model.moving;

import java.util.List;

import static bridge.constants.ConstMessage.*;
import static bridge.constants.ResultMessage.*;
import static bridge.model.moving.*;

public class OutputView {

    StringBuilder upperBridge;
    StringBuilder lowerBridge;

    public void printMap(List<String> user, List<String> score) {
        upperBridge = new StringBuilder();
        lowerBridge = new StringBuilder();

        makeResult(user, score);
        System.out.println(upperBridge);
        System.out.println(lowerBridge);
        System.out.println();

    }

    public void makeUpper(int idx, List<String> score){
        upperBridge.append(String.format(INPUT_OK, score.get(idx)));
        lowerBridge.append(INPUT_NO);

        if (idx != score.size() - 1) {
            upperBridge.append(BAR);
            lowerBridge.append(BAR);
        }
    }

    public void makeLower(int idx, List<String> score) {
        lowerBridge.append(String.format(INPUT_OK, score.get(idx)));
        upperBridge.append(INPUT_NO);

        if (idx != score.size() - 1) {
            upperBridge.append(BAR);
            lowerBridge.append(BAR);
        }
    }

    public void makeMap(int idx, List<String> user, List<String> score) {
        if (user.get(idx).equals(up.getUpDown())) {
            makeUpper(idx, score);
            return;
        }
        makeLower(idx, score);
    }

    public void makeResult(List<String> user, List<String> score) {
        setResultStart();
        for (int idx = 0; idx < score.size(); idx++) {
            makeMap(idx, user, score);
        }
        setResultEnd();
    }

    public void setResultStart() {
        upperBridge.append(OPEN_BRACKET);
        lowerBridge.append(OPEN_BRACKET);
    }

    public void setResultEnd() {
        upperBridge.append(CLOSE_BRACKET);
        lowerBridge.append(CLOSE_BRACKET);
    }

    public void printResult(String gameResult, int count) {
        System.out.println(FINAL_RESULT);
        System.out.println(upperBridge);
        System.out.println(lowerBridge);
        System.out.println();
        System.out.println(GAME_RESULT+gameResult);
        System.out.print(GAME_COUNT+count);
    }
}
