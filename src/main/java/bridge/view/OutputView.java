package bridge.view;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeGameResult;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(BridgeGameResult bridgeGameResult) {
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
    public void printResult(BridgeGameResult bridgeGameResult, BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGameResult);
        System.out.printf("게임 성공 여부: %b", bridgeGameResult.getSuccess());
        System.out.printf("총 시도한 횟수: %d", bridgeGame.getTryCount());
    }
}
