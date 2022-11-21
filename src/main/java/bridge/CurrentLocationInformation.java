package bridge;

import java.util.ArrayList;
import java.util.List;

public class CurrentLocationInformation {
    private final OutputView outputView = new OutputView();
    private static List<String> str = new ArrayList<>();
    private static List<String> upStr = new ArrayList<>();
    private static int check = 0;

    public static void init() {
        str.clear();
        upStr.clear();
    }


    public void showMyLocation(List<String> bridge, String moving, int count) {
        String gameState = "";
        check = count;
        makeUpLocation(bridge, moving);
        makeDownLocation(bridge, moving);
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

    private void makeUpLocation(List<String> bridge, String moving) {
        List<Boolean> bridgeExist = makeUpLocationExist(bridge);

        String state = "[ ";
        state += gameIng(bridgeExist, bridge, moving);
        if (check > 0) {
            state = "";
            state += upStr.get(check - 1) + gameIng(bridgeExist, bridge, moving);
        }
        upStr.add(state);
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

    private void makeDownLocation(List<String> bridge, String moving) {
        List<Boolean> bridgeTrueAndFalse = makeDownLocationExist(bridge);

        String state = "[ ";
        state += gameIng(bridgeTrueAndFalse, bridge, moving);
        if (check > 0) {
            state = "";
            state += str.get(check - 1) + gameIng(bridgeTrueAndFalse, bridge, moving);
        }
        str.add(state);
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

    private String gameIng(List<Boolean> test, List<String> bridge, String moving) {
        String ing = "";
        if (check == 0) {
            ing += showUpAndDownResult(test, bridge, moving);
        }
        if (check > 0) {
            ing += " | ";
            ing += showUpAndDownResult(test, bridge, moving);
        }
        return ing;
    }

    private String showUpAndDownResult(List<Boolean> test, List<String> bridge, String moving) {
        if (test.get(check) && bridge.get(check).equals(moving)) {
            return "O";
        }
        if (!test.get(check) && !bridge.get(check).equals(moving)) {
            return "X";
        }
        return " ";
    }
}
