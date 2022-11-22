package bridge.view;

import bridge.BridgeGame;
import bridge.enums.OutMsg;

public class OutputView {
    public void printInitMessage() {
        System.out.println(OutMsg.INIT.getMessage() + "\n");
    }

    public void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame + "\n");
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        System.out.println(bridgeGame + "\n");
        String gameWon = "실패";
        if (bridgeGame.gameWon()) {
            gameWon = "성공";
        }
        System.out.println("게임 성공 여부: " + gameWon);
        System.out.println("총 시도한 횟수: " + bridgeGame.getTrials());
    }
}
