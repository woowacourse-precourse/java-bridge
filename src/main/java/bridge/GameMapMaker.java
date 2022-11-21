package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bridge.BridgeGame.down;
import static bridge.BridgeGame.up;
import static bridge.View.TemplateLetters.*;

public class GameMapMaker {

    public List<String> makeMap(PassOrNot result, String input, int index) {
        List<String> printMapList = new ArrayList<>();
        inputUp(result, input, index);
        inputDown(result, input, index);
        String upList = getUpList();
        String downList = getDownList();
        printMapList.add(upList);
        printMapList.add(downList);
        return printMapList;
    }

    private static String getDownList() {
        String downJoin = String.join("", down);
        String downList = downJoin + END.getValue();
        return downList;
    }

    private static String getUpList() {
        String upJoin = String.join("", up);
        String upList = upJoin + END.getValue();
        return upList;
    }

    private static void inputDown(PassOrNot result, String input, int index) {
        if (Objects.equals(input, UpDown.DOWN.getValue())) {
            downAndFirst(result, index);
            downAndElse(result, index);
        }
    }

    private static void inputUp(PassOrNot result, String input, int index) {
        if (Objects.equals(input, UpDown.UP.getValue())) {
            upAndFirst(result, index);
            upAndElse(result, index);
        }
    }

    private static void downAndElse(PassOrNot result, int index) {
        if (index != 0) {
            up.add(MIDDLE.getValue()); // 중간과 마지막
            up.add(BLANK.getValue());
            down.add(MIDDLE.getValue());
            down.add(result.getValue());
        }
    }

    private static void downAndFirst(PassOrNot result, int index) {
        if (index == 0) { // 첫 칸
            up.add(START.getValue());
            up.add(BLANK.getValue());
            down.add(START.getValue());
            down.add(result.getValue());
        }
    }

    private static void upAndElse(PassOrNot result, int index) {
        if (index != 0) {
            up.add(MIDDLE.getValue()); // 중간과 마지막
            up.add(result.getValue());
            down.add(MIDDLE.getValue());
            down.add(BLANK.getValue());
        }
    }

    private static void upAndFirst(PassOrNot result, int index) {
        if (index == 0) { // 첫 칸
            up.add(START.getValue());
            up.add(result.getValue());
            down.add(START.getValue());
            down.add(BLANK.getValue());
        }
    }
}
