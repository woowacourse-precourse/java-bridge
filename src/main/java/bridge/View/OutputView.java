package bridge.View;

import bridge.Domain.BridgeGame;

import java.util.List;

public class OutputView {

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
        printEqual(matchResult,bridge,way,i);
        printNotEqual(matchResult,bridge,way,i);
        printWall(i,matchResult);
    }

    public void printEqual(List<Boolean> matchResult, List<String> bridge, String way, int i) {
        if (bridge.get(i).equals(way)) {
            String correct = " O ";
            if (!matchResult.get(i)) {
                correct = "   ";
            }
            System.out.print(correct);
        }
    }

    public void printNotEqual(List<Boolean> matchResult, List<String> bridge, String way, int i) {
        if (!bridge.get(i).equals(way)) {
            String wrong = " X ";
            if (matchResult.get(i)) {
                wrong = "   ";
            }
            System.out.print(wrong);
        }
    }

    public void printWall(int i,List<Boolean> matchResult ) {
        if (i != matchResult.size() - 1) {
            System.out.print("|");
        }
    }
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getMatchResult(),bridgeGame.getBridge());
        String success = "성공";
        if (!bridgeGame.isSuccecss()) { success = "실패"; }
        System.out.println("게임 성공 여부: "+ success);
        System.out.println("총 시도한 횟수: "+ bridgeGame.getGameCount());
    }
}
