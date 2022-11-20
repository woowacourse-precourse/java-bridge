package bridge.View;

import bridge.Domain.BridgeGame;

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
    public void printMap(List<Boolean> matchResult,List<String> bridge) {
        System.out.print("[");
        printBridgeCell(matchResult,bridge,"U");
        System.out.println("]");
        System.out.print("[");
        printBridgeCell(matchResult,bridge,"D");
        System.out.println("]");
    }
    public void printBridgeCell(List<Boolean> matchResult, List<String> bridge, String way) {
        for (int i = 0; i < matchResult.size(); i++) {
            printBridgeCellLoop(matchResult,bridge,way,i);
        }
    }

    public void printBridgeCellLoop(List<Boolean> matchResult, List<String> bridge, String way, int i) {
        if (bridge.get(i).equals(way)) {
            String correct = " O ";
            if (!matchResult.get(i)) {
                correct = "   ";
            }
            System.out.print(correct);
        }
        if (!bridge.get(i).equals(way)) {
            String wrong = " X ";
            if (matchResult.get(i)) {
                wrong = "   ";
            }
            System.out.print(wrong);
        }
        if (i != matchResult.size() - 1) {
            System.out.print("|");
        }
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getMatchResult(),bridgeGame.getBridge());
        String success = "성공";
        if (!bridgeGame.isSuccecs()) { success = "실패"; }
        System.out.println("게임 성공 여부: "+ success);
        System.out.println("총 시도한 횟수: "+ bridgeGame.getGameCount());
    }
}
