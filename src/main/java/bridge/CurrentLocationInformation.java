package bridge;

import java.util.ArrayList;
import java.util.List;

public class CurrentLocationInformation {
    private final OutputView outputView = new OutputView();
    private String upStateTest = "";
    private String downStateTest = "";
    private String stay = "";
    public static List<String> str = new ArrayList<>();
    public static List<String> upStr = new ArrayList<>();


    public void showMyLocation(List<String> bridge, String moving, int count) {
        String gameState = "";
        makeUpLocation(bridge, count, moving);
        makeDownLocation(bridge, count, moving);
        outputView.printMap(gameState);
    }

    private void makeUpLocation(List<String> bridge, int count, String moving) {
        List<Boolean> test = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            if (bridge.get(i).equals("U")) {
                test.add(true);
            }
            if (bridge.get(i).equals("D")) {
                test.add(false);
            }
        }
        String state = "[ ";
        if (count == 0) {
            state += gameIng(test, bridge, count, moving);
            upStr.add(state);
        } else {
            state = "";
            state += upStr.get(count - 1);
            state += gameIng(test, bridge, count, moving);
            upStr.add(state);
        }
        state += " ]";
        outputView.printMap(state);
    }

    private void makeDownLocation(List<String> bridge, int count, String moving) {
        List<Boolean> test = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            if (bridge.get(i).equals("D")) {
                test.add(true);
            }
            if (bridge.get(i).equals("U")) {
                test.add(false);
            }
        }
        String state = "[ ";
        if (count == 0) {
            state += gameIng(test, bridge, count, moving);
            str.add(state);
        } else {
            state = "";
            state += str.get(count - 1);
            state += gameIng(test, bridge, count, moving);
            str.add(state);
        }
        state += " ]";
        outputView.printMap(state);
    }

    private String gameIng(List<Boolean> test, List<String> bridge, int count, String moving) { // count는 라운드
        String ing = "";
        // 왜 인스턴스 변수로 만들면 위 아래 둘 다 O O가 출력 될까..?
        for (int i = 0; i < 1; i++) {
            if (count == 0) {
                ing += showUpAndDownResult(test, bridge, count, moving);
            }
            if (count > 0) {
                for (int j = 0; j < 1; j++) {
                    ing += " | ";
                }
                ing += showUpAndDownResult(test, bridge, count, moving);
            }
        }
        return ing;
    }

    private String showUpAndDownResult(List<Boolean> test, List<String> bridge, int count, String moving) {
        if (test.get(count) && bridge.get(count).equals(moving)) {
            return "O";
        }
        if (!test.get(count) && !bridge.get(count).equals(moving)) {
            return "X";
        }
        return " ";
    }
}
