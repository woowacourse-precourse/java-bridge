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

    public void printResult(BridgeGameResult bridgeGameResult, BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGameResult);
        System.out.printf("게임 성공 여부: %b", bridgeGameResult.getSuccess());
        System.out.printf("총 시도한 횟수: %d", bridgeGame.getTryCount());
    }
}
