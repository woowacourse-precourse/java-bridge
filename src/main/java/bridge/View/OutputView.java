package bridge.View;

import bridge.Model.BridgeGame;

public class OutputView {

    public void printMap() {
        System.out.println(BridgeGame.upperResult);
        System.out.println(BridgeGame.lowerResult);
        System.out.println();
    }

    public void printResult(boolean successFlag,int runCount) {
        System.out.println("최종 게임 결과");
        System.out.println(BridgeGame.upperResult);
        System.out.println(BridgeGame.lowerResult);
        System.out.println();
        if (successFlag) {
            System.out.println("게임 성공 여부: " + "성공");
        } else {
            System.out.println("게임 성공 여부: " + "실패");
        }
        System.out.println("총 시도한 횟수: "+runCount);
    }
}
