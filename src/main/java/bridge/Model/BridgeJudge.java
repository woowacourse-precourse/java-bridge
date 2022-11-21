package bridge.Model;

import java.util.ArrayList;
import java.util.List;

public class BridgeJudge {
    public static final BridgeJudge getInstance = new BridgeJudge();
    private static List<String> bridgeMapUp = new ArrayList<>();
    private static List<String> bridgeMapDown = new ArrayList<>();

    // userInput 과 madeBridge 를 비교하여 결과를 bridge 에 저장하는 함수
    public void judgeInput(String userInput, String madeBridge, Bridge bridge) {
        if(userInput.equals(madeBridge)) {
            if(userInput.equals("U")) {
                bridge.updateUp("O");
                bridge.updateDown(" ");
            }
            if(userInput.equals("D")) {
                bridge.updateDown("O");
                bridge.updateUp(" ");
            }
        }

        if(!userInput.equals(madeBridge)) {
            Bridge.bridge.setRightAnswer(false);
            if(userInput.equals("U")) {
                bridge.updateUp("X");
                bridge.updateDown(" ");
            }
            if(userInput.equals("D")) {
                bridge.updateDown("X");
                bridge.updateUp(" ");
            }
        }
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
        for(int index = 0; index<count*2+1; index++) {
            if(index == 0) {
                bridgeMap.add("[ ");
                continue;
            }
            if(index%2 != 0) {
                bridgeMap.add(result.get(resultIndex));
                resultIndex++;
                continue;
            }
            if(index != count*2) {
                bridgeMap.add(" | ");
                continue;
            }
            if(index == count*2) {
                bridgeMap.add(" ]");
            }
        }
        return bridgeMap;
    }

    public void init() {
        bridgeMapUp = new ArrayList<>();
        bridgeMapDown = new ArrayList<>();
    }
}
