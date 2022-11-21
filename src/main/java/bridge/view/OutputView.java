package bridge.view;

import bridge.controller.GameStatus;
import bridge.domain.operator.BridgeResult;
import bridge.utils.OutputMessage;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeResult bridgeResult) {
        String upBridgeMap = renderMap(bridgeResult.getUpBridge());
        String downBridgeMap = renderMap(bridgeResult.getDownBridge());
        System.out.println("[" + upBridgeMap + "]");
        System.out.println("[" + downBridgeMap + "]");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeResult bridgeResult, GameStatus gameStatus) {
        System.out.println(OutputMessage.FINAL_RESULT);
        printMap(bridgeResult);
        System.out.println("게임 성공 여부: " + toKorean(gameStatus.isSuccess()));
        System.out.println("총 시도한 횟수: " + gameStatus.getAttempt());
    }

    private String renderMap(List<String> bridge) {
        StringBuilder map = new StringBuilder();
        for (int i = 0; i < bridge.size() - 1; i++) {
            map.append(bridge.get(i)).append("|");
        }
        return map + bridge.get(bridge.size() - 1);
    }

    private String toKorean(boolean success) {
        if (success) {
            return "성공";
        }
        return "실패";
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
