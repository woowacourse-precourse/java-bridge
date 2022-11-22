package bridge.Model;

import bridge.Constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class BridgeJudge {
    public static final BridgeJudge getInstance = new BridgeJudge();
    private static List<String> bridgeMapUp = new ArrayList<>();
    private static List<String> bridgeMapDown = new ArrayList<>();

    // userInput 과 madeBridge 를 비교하여 결과를 bridge 에 저장하는 함수
    public void judgeInput(String userInput, String madeBridge, Bridge bridge) {
        if (userInput.equals(madeBridge)) {
            judgeEqual(userInput, bridge);
            return;
        }

        judgeNotEqual(userInput, bridge);
    }

    private void judgeEqual(String userInput, Bridge bridge) {
        if (userInput.equals(Constant.UP_STR)) {
            bridge.updateUp(Constant.RIGHT);
            bridge.updateDown(Constant.SPACE);
            return;
        }
        bridge.updateDown(Constant.RIGHT);
        bridge.updateUp(Constant.SPACE);
    }

    private void judgeNotEqual(String userInput, Bridge bridge) {
        bridge.setRightAnswer(false);
        if (userInput.equals(Constant.UP_STR)) {
            bridge.updateUp(Constant.WRONG);
            bridge.updateDown(Constant.SPACE);
            return;
        }
        bridge.updateDown(Constant.WRONG);
        bridge.updateUp(Constant.SPACE);
    }

    public static List<String> getBridgeMapDown(List<String> result, int count) {
        bridgeMapDown = setBridge(result, count);
        return bridgeMapDown;
    }

    public static List<String> getBridgeMapUp(List<String> result, int count) {
        bridgeMapUp = setBridge(result, count);
        return bridgeMapUp;
    }

    private static List<String> setBridge(List<String> result, int count) {
        List<String> bridgeMap = new ArrayList<>();
        int resultIndex = 0;
        count = count * 2 + 1;
        for (int index = 0; index < count; index++) {
            if (index == 0) {
                bridgeMap.add("[ ");
                continue;
            }
            if (index % 2 != 0) {
                bridgeMap.add(result.get(resultIndex++));
                continue;
            }
            if (index != count - 1) {
                bridgeMap.add(" | ");
                continue;
            }
            bridgeMap.add(" ]");
        }
        return bridgeMap;
    }

    public void init() {
        bridgeMapUp = new ArrayList<>();
        bridgeMapDown = new ArrayList<>();
    }
}
