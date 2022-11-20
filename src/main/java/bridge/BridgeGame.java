package bridge;

import java.util.ArrayList;
import java.util.List;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();
    private int bridgeCount = 0;

    OutputView outputView = new OutputView();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridge, String moving) {
        moveBridge(bridge, moving);
        outputView.printMap(upBridge, downBridge);
    }

    public void moveBridge(List<String> bridge, String moving) {
        if (bridge.get(bridgeCount).equals(moving) && moving.equals("U")) {
            upBridge.add("O");
            downBridge.add(" ");
            bridgeCount++;
            return;
        }

        if (bridge.get(bridgeCount).equals(moving) && moving.equals("D")) {
            upBridge.add(" ");
            downBridge.add("O");
            bridgeCount++;
            return;
        }

        if (!bridge.get(bridgeCount).equals(moving) && moving.equals("U")) {
            upBridge.add("X");
            downBridge.add(" ");
            bridge.add("X");
            return;
        }

        if (!bridge.get(bridgeCount).equals(moving) && moving.equals("D")) {
            upBridge.add(" ");
            downBridge.add("X");
            bridge.add("X");
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> bridge) {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
        bridge.remove(bridge.size()-1);
        bridgeCount = 0;
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public int getBridgeCount() {
        return bridgeCount;
    }
}
