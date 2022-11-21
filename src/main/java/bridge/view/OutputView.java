package bridge.view;

import bridge.BridgeGameResult;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(BridgeGameResult bridgeGameResult) {
        String upSideIndex = "[ " +String.join(" | ", bridgeGameResult.getUpBridge()) + " ]";
        String downSideIndex = "[ " +String.join(" | ", bridgeGameResult.getDownBridge()) + " ]";
        System.out.println(upSideIndex);
        System.out.println(downSideIndex);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
