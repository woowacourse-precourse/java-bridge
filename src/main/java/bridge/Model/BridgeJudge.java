package bridge.Model;

import bridge.Constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class BridgeJudge {
    public static final BridgeJudge getInstance = new BridgeJudge();
    private static List<String> bridgeMapUp = new ArrayList<>();
    private static List<String> bridgeMapDown = new ArrayList<>();

    // userInput 과 madeBridge 를 비교하여 결과를 bridge 에 저장하는 함수
    public void judgeReflect(String userInput, String madeBridge, Bridge bridge) {
        if (userInput.equals(madeBridge)) {
            resultEqual(userInput, bridge);
            return;
        }

        resultNotEqual(userInput, bridge);
    }

    private void resultEqual(String userInput, Bridge bridge) {
        if (userInput.equals(Constant.UP_STR)) {
            bridge.updateUp(Constant.RIGHT);
            bridge.updateDown(Constant.SPACE);
            return;
        }
        bridge.updateDown(Constant.RIGHT);
        bridge.updateUp(Constant.SPACE);
    }

    private void resultNotEqual(String userInput, Bridge bridge) {
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
        bridgeMapDown = saveMap(result, count*2+1);
        return bridgeMapDown;
    }

    public static List<String> getBridgeMapUp(List<String> result, int count) {
        bridgeMapUp = saveMap(result, count*2+1);
        return bridgeMapUp;
    }

    private static List<String> saveMap(List<String> result, int count) {
        List<String> bridgeMap = new ArrayList<>();
        int resultIndex = 0;
        for (int index = 0; index < count; index++) {
            String judge = judgeIndex(index, count);
            if (judge == null) {
                bridgeMap.add(result.get(resultIndex++));
                continue;
            }
            bridgeMap.add(judge);
        }
        return bridgeMap;
    }

    private static String judgeIndex(int index, int count) {
        if (index == 0) {
            return "[ ";
        }
        if (index % 2 != 0) {
            return null;
        }
        if (index % 2 == 0 && index != count - 1) {
            return " | ";
        }
        return " ]";
    }

    public void init() {
        bridgeMapUp = new ArrayList<>();
        bridgeMapDown = new ArrayList<>();
    }
}
