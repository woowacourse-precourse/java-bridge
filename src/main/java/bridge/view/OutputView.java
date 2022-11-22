package bridge.view;

import bridge.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public static void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame.getBridgeStatusString());
    }

    private static String getSuccessOrFailureString(BridgeGame bridgeGame) {
        if (bridgeGame.isSuccess()) {
            return "성공";
        }
        return "실패";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        System.out.println();
        System.out.println("게임 성공 여부: " + getSuccessOrFailureString(bridgeGame));
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }
}
