package bridge.ui;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.GameStatus;

import java.util.List;

public class OutputView {

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(Bridge bridge) {
        List<String> upperBridgeMapInfo = bridge.getUserRouteInTargetBridge("U");
        List<String> belowBridgeMapInfo = bridge.getUserRouteInTargetBridge("D");

        String upperBridgeMap = getFinalBridgeMap(upperBridgeMapInfo);
        String belowBridgeMap = getFinalBridgeMap(belowBridgeMapInfo);

        System.out.println(upperBridgeMap);
        System.out.println(belowBridgeMap);
    }

    /**
    * 각 다리의 최종 Map을 [ O | O |  | X ] 와 같이 문자열로 만들어 반환합니다.
    */
    public String getFinalBridgeMap(List<String> targetBridgeMapInfo) {
        String eachBridgeMap = "";
        for (int round=0; round<targetBridgeMapInfo.size(); round++) {
            eachBridgeMap += targetBridgeMapInfo.get(round);
            if (round != targetBridgeMapInfo.size()-1) { // 마지막 칸이 아니라면 " | " 추가
                eachBridgeMap += " | ";
            }
        }
        return "[ " + eachBridgeMap + " ]";
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.bridge);
        GameStatus gameResult = bridgeGame.currentStatus;
        System.out.println("게임 성공 여부: " + gameResult.getTitle());
        System.out.println("총 시도한 횟수: " + bridgeGame.attemptCount);
    }
}
