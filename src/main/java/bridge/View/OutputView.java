package bridge.View;

import bridge.Model.BridgeGame;

/**
 * 모델한테서 바로 받아오는거 안됨 리팩토링 필요
 **/
public class OutputView {

    public void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame.upperResult);
        System.out.println(bridgeGame.lowerResult);
        System.out.println();
    }

    public void printResult(BridgeGame bridgeGame, boolean successFlag) {
        printFinalResult(bridgeGame);
        printStatistics(bridgeGame, successFlag);
    }

    private static void printFinalResult(BridgeGame bridgeGame) {
        System.out.println(UiMessage.FINAL_RESULT.getValue());
        System.out.println(bridgeGame.upperResult);
        System.out.println(bridgeGame.lowerResult);
        System.out.println();
    }

    private static void printStatistics(BridgeGame bridgeGame, boolean successFlag) {
        if (successFlag) {
            System.out.println(UiMessage.GAME_SUCCESS.getValue());
        } else {
            System.out.println(UiMessage.GAME_FAIL.getValue());
        }
        System.out.println(UiMessage.TOTAL_TRY.getValue() + bridgeGame.runCount);
    }


}
