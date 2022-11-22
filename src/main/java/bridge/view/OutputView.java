package bridge.view;

import bridge.model.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame);
    }

    public void printResult(BridgeGame bridgeGame, boolean isSuccess) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        System.out.println("게임 성공 여부: " + Success.getMessage(isSuccess));
        System.out.println("총 시도한 횟수: " + bridgeGame.getRepeatCount());
    }
}
