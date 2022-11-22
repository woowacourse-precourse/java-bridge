package bridge.view;

import bridge.model.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printbr() {
        System.out.println();
    }

    public static void printgameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public static void printMap(StringBuilder upline, StringBuilder downline) {
        System.out.println(upline + "\n" + downline + "\n");
    }

    public static void printResult(BridgeGame bridgeGame, String success, int count) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.upline(), bridgeGame.downline());
        System.out.println("게임 성공 여부: " + success);
        System.out.println("총 시도한 횟수: " + count);

    }
}
