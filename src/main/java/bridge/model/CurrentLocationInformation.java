package bridge.model;

import bridge.command.MiniMapState;
import bridge.command.UserMove;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CurrentLocationInformation {
    private static final OutputView outputView = new OutputView();
    private static List<String> downStairs = new ArrayList<>();
    private static List<String> upStairs = new ArrayList<>();
    private static int check = 0;


    public static void init() {
        downStairs.clear();
        upStairs.clear();
    }


    public void showMyLocation(List<String> bridge, String moving, int count) {
        check = count;
        makeUpLocation(bridge, moving);
        makeDownLocation(bridge, moving);
        System.out.println();
    }

    public static String getResultLocation() {
        int size = upStairs.size();
        String resultLocation = "";
        resultLocation += upStairs.get(size - 1);
        resultLocation += MiniMapState.END_BRIDGE_FRAME.getMiniMapState() + "\n";
        resultLocation += downStairs.get(size - 1);
        resultLocation += MiniMapState.END_BRIDGE_FRAME.getMiniMapState();
        return resultLocation;
    }

    private void makeUpLocation(List<String> bridge, String moving) {
        List<Boolean> bridgeExist = makeUpLocationExist(bridge);
        String state = MiniMapState.START_BRIDGE_FRAME.getMiniMapState();
        state += makeProgressStatus(bridgeExist, bridge, moving);
        if (check > 0) {
            state = "";
            state += upStairs.get(check - 1) + makeProgressStatus(bridgeExist, bridge, moving);
        }
        upStairs.add(state);
        state += MiniMapState.END_BRIDGE_FRAME.getMiniMapState();
        outputView.printMap(state);
    }

    private List<Boolean> makeUpLocationExist(List<String> bridge) {
        List<Boolean> bridgeExist = new ArrayList<>();
        for (int index = 0; index < bridge.size(); index++) {
            if (bridge.get(index).equals(UserMove.UP.getUserMove())) {
                bridgeExist.add(true);
            }
            if (bridge.get(index).equals(UserMove.DOWN.getUserMove())) {
                bridgeExist.add(false);
            }
        }
        return bridgeExist;
    }

    private void makeDownLocation(List<String> bridge, String moving) {
        List<Boolean> bridgeExist = makeDownLocationExist(bridge);
        String state = MiniMapState.START_BRIDGE_FRAME.getMiniMapState();
        state += makeProgressStatus(bridgeExist, bridge, moving);
        if (check > 0) {
            state = "";
            state += downStairs.get(check - 1) + makeProgressStatus(bridgeExist, bridge, moving);
        }
        downStairs.add(state);
        state += MiniMapState.END_BRIDGE_FRAME.getMiniMapState();
        outputView.printMap(state);
    }

    private List<Boolean> makeDownLocationExist(List<String> bridge) {
        List<Boolean> bridgeExist = new ArrayList<>();
        for (int index = 0; index < bridge.size(); index++) {
            if (bridge.get(index).equals(UserMove.DOWN.getUserMove())) {
                bridgeExist.add(true);
            }
            if (bridge.get(index).equals(UserMove.UP.getUserMove())) {
                bridgeExist.add(false);
            }
        }
        return bridgeExist;
    }

    private String makeProgressStatus(List<Boolean> bridgeExist, List<String> bridge, String moving) {
        String currentStatus = "";
        if (check == 0) {
            currentStatus += showUpAndDownResult(bridgeExist, bridge, moving);
        }
        if (check > 0) {
            currentStatus += MiniMapState.LINE.getMiniMapState();
            currentStatus += showUpAndDownResult(bridgeExist, bridge, moving);
        }
        return currentStatus;
    }

    private String showUpAndDownResult(List<Boolean> bridgeExist, List<String> bridge, String moving) {
        if (bridgeExist.get(check) && bridge.get(check).equals(moving)) {
            return MiniMapState.POSSIBLE_MOVE.getMiniMapState();
        }
        if (!bridgeExist.get(check) && !bridge.get(check).equals(moving)) {
            return MiniMapState.NOT_POSSIBLE_MOVE.getMiniMapState();
        }
        return MiniMapState.NOT_EXIST.getMiniMapState();
    }
}
