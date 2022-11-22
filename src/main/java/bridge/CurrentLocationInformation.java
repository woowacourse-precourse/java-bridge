package bridge;

import java.util.ArrayList;
import java.util.List;

public class CurrentLocationInformation {
    private static final OutputView outputView = new OutputView();
    private static List<String> str = new ArrayList<>();
    private static List<String> upStr = new ArrayList<>();
    private static int check = 0;


    public static void init() {
        str.clear();
        upStr.clear();
    }


    public void showMyLocation(List<String> bridge, String moving, int count) {
        check = count;
        makeUpLocation(bridge, moving);
        makeDownLocation(bridge, moving);
        System.out.println();
    }

    public static String getResultLocation() {
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
        List<Boolean> bridgeExist = new ArrayList<>();
        for (int index = 0; index < bridge.size(); index++) {
            if (bridge.get(index).equals("U")) {
                bridgeExist.add(true);
            }
            if (bridge.get(index).equals("D")) {
                bridgeExist.add(false);
            }
        }
        return bridgeExist;
    }

    private void makeDownLocation(List<String> bridge, String moving) {
        List<Boolean> bridgeExist = makeDownLocationExist(bridge);
        String state = "[ ";
        state += gameIng(bridgeExist, bridge, moving);
        if (check > 0) {
            state = "";
            state += str.get(check - 1) + gameIng(bridgeExist, bridge, moving);
        }
        str.add(state);
        state += " ]";
        outputView.printMap(state);
    }

    private List<Boolean> makeDownLocationExist(List<String> bridge) {
        List<Boolean> bridgeExist = new ArrayList<>();
        for (int index = 0; index < bridge.size(); index++) {
            if (bridge.get(index).equals("D")) {
                bridgeExist.add(true);
            }
            if (bridge.get(index).equals("U")) {
                bridgeExist.add(false);
            }
        }
        return bridgeExist;
    }

    private String gameIng(List<Boolean> bridgeExist, List<String> bridge, String moving) {
        String ing = "";
        if (check == 0) {
            ing += showUpAndDownResult(bridgeExist, bridge, moving);
        }
        if (check > 0) {
            ing += " | ";
            ing += showUpAndDownResult(bridgeExist, bridge, moving);
        }
        return ing;
    }

    private String showUpAndDownResult(List<Boolean> bridgeExist, List<String> bridge, String moving) {
        if (bridgeExist.get(check) && bridge.get(check).equals(moving)) {
            return "O";
        }
        if (!bridgeExist.get(check) && !bridge.get(check).equals(moving)) {
            return "X";
        }
        return " ";
    }
}
