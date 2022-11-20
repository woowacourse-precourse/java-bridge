package bridge;

import java.util.ArrayList;
import java.util.List;

public class CurrentLocationInformation {
    private final OutputView outputView = new OutputView();
    public static List<String> str = new ArrayList<>();
    public static List<String> upStr = new ArrayList<>();


    public void showMyLocation(List<String> bridge, String moving, int count) {
        String gameState = "";
        makeUpLocation(bridge, count, moving);
        makeDownLocation(bridge, count, moving);
        outputView.printMap(gameState);
    }

    public String getResultLocation() {
        int size = upStr.size();
        String resultLocation = "";
        resultLocation += upStr.get(size - 1);
        resultLocation += " ]" + "\n";
        resultLocation += str.get(size - 1);
        resultLocation += " ]";
        return resultLocation;
    }

    private void makeUpLocation(List<String> bridge, int count, String moving) {
        List<Boolean> bridgeExist = makeUpLocationExist(bridge);

        String state = "[ ";
        if (count == 0) {
            state += gameIng(bridgeExist, bridge, count, moving);
            upStr.add(state);
        } else {
            state = "";
            state += upStr.get(count - 1);
            state += gameIng(bridgeExist, bridge, count, moving);
            upStr.add(state);
        }
        state += " ]";
        outputView.printMap(state);
    }

    private List<Boolean> makeUpLocationExist(List<String> bridge) {
        List<Boolean> bridgeTrueAndFalse = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            if (bridge.get(i).equals("U")) {
                bridgeTrueAndFalse.add(true);
            }
            if (bridge.get(i).equals("D")) {
                bridgeTrueAndFalse.add(false);
            }
        }
        return bridgeTrueAndFalse;
    }

    private void makeDownLocation(List<String> bridge, int count, String moving) {
        List<Boolean> bridgeTrueAndFalse = makeDownLocationExist(bridge);

        String state = "[ ";
        if (count == 0) {
            state += gameIng(bridgeTrueAndFalse, bridge, count, moving);
            str.add(state);
        } else if (count != 0) {
            state = "";
            state += str.get(count - 1);
            state += gameIng(bridgeTrueAndFalse, bridge, count, moving);
            str.add(state);
        }
        state += " ]";
        outputView.printMap(state);
    }

    private List<Boolean> makeDownLocationExist(List<String> bridge) {
        List<Boolean> bridgeTrueAndFalse = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            if (bridge.get(i).equals("D")) {
                bridgeTrueAndFalse.add(true);
            }
            if (bridge.get(i).equals("U")) {
                bridgeTrueAndFalse.add(false);
            }
        }
        return bridgeTrueAndFalse;
    }

    private String gameIng(List<Boolean> test, List<String> bridge, int count, String moving) { // count는 라운드
        String ing = "";
        if (count == 0) {
            ing += showUpAndDownResult(test, bridge, count, moving);
        }
        if (count > 0) {
            ing += " | ";
            ing += showUpAndDownResult(test, bridge, count, moving);
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
