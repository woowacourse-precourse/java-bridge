package bridge.Controller;

import bridge.Model.Bridge;
import bridge.Model.BridgeJudge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int index = 0;
    private int count = 1;
    private int tried = 1;
    String gameResult = "성공";
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */


    public List<List<String>> move(List<String> madeBridge, String userDirection) {
        List<List<String>> userBridge = new ArrayList<>();
        BridgeJudge.getInstance.judgeInput(userDirection, madeBridge.get(index), Bridge.bridge);

        userBridge.add(BridgeJudge.getBridgeMapUp(Bridge.bridge.getUp(), count));
        userBridge.add(BridgeJudge.getBridgeMapDown(Bridge.bridge.getDown(), count));

        count++;
        index++;

        return userBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String cont) {
        if (cont.equals("R")) {
            this.retryInit();
            return true;
        }
        gameResult = "실패";
        return false;
    }

    public int getCount() {
        return count;
    }

    public int getTried() {
        return tried;
    }

    public String getGameResult() {
        return gameResult;
    }

    private void retryInit() {
        index = 0;
        count = 1;
        Bridge.bridge.init();
        BridgeJudge.getInstance.init();
        tried++;
    }
}
