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
        String UpperBridgeMapInfo = printEachBridgeMap(bridge, "U");
        String BelowBridgeMapInfo = printEachBridgeMap(bridge, "D");
        System.out.println(UpperBridgeMapInfo);
        System.out.println(BelowBridgeMapInfo);
    }

    public String printEachBridgeMap(Bridge bridge, String direction) {
        List<String> mapInfo = bridge.getUserRouteInTargetBridge(direction);
        String eachBridgeMap = "[ ";
        for (int round=0; round<mapInfo.size(); round++) {
            eachBridgeMap += mapInfo.get(round);
            if (round != mapInfo.size()-1) { // 마지막이 아니라면
                eachBridgeMap += " | ";
            }
        }
        eachBridgeMap += " ]";
        return eachBridgeMap;
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.bridge);
        GameStatus gameResult = bridgeGame.currentStatus;
        if (gameResult.equals(GameStatus.SUCCESS)) {
            System.out.println("게임 성공 여부: 성공");
        } if (gameResult.equals(GameStatus.FAIL)) {
            System.out.println("게임 성공 여부: 실패");
        }

        System.out.println("총 시도한 횟수: " + bridgeGame.attemptCount);
    }
}
