package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    BridgeUI bridgeUI = new BridgeUI();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> playerMoving, List<Integer> moveOutcome) {
        List<Integer> bridgeUpper = new ArrayList<>();
        List<Integer> bridgeDown = new ArrayList<>();
        bridgeUpper = setBridgeUpper(playerMoving, moveOutcome);
        bridgeDown = setBridgeDown(playerMoving, moveOutcome);
        makeBridge(bridgeUpper);
        makeBridge(bridgeDown);
    }

    public List<Integer> setBridgeUpper(List<String> playerMoving, List<Integer> moveOutcome) {
        List<Integer> bridgeUpper = new ArrayList<>();
        for (int i = 0; i < playerMoving.size(); i++) {
            if (playerMoving.get(i).equals("U")) {
                bridgeUpper.add(makeBridgeShare(moveOutcome.get(i)));
                continue;
            }
            bridgeUpper.add(2);
        }
        return bridgeUpper;
    }

    public List<Integer> setBridgeDown(List<String> playerMoving, List<Integer> moveOutcome) {
        List<Integer> bridgeDown = new ArrayList<>();
        for (int i = 0; i < playerMoving.size(); i++) {
            if (playerMoving.get(i).equals("D")) {
                bridgeDown.add(makeBridgeShare(moveOutcome.get(i)));
                continue;
            }
            bridgeDown.add(2);
        }
        return bridgeDown;
    }

    public int makeBridgeShare(int moveOutcome) {
        if (moveOutcome == 1) {
            return 1;
        }
        if (moveOutcome == 0) {
            return 0;
        }
        return 2;
    }

    public void makeBridge(List<Integer> bridge) {
        bridgeUI.start();
        for (int i = 0; i < bridge.size(); i++) {
            printOutcome(bridge.get(i));
            bridgeUI.divideLine();
        }
        bridgeUI.end();
    }

    public void printOutcome(int bridge) {
        if (bridge == 1) {
            bridgeUI.success();
            return;
        }
        if (bridge == 0) {
            bridgeUI.fail();
            return;
        }
        if (bridge == 2) {
            bridgeUI.empty();
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
