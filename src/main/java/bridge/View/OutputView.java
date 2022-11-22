package bridge.View;

import bridge.Domain.BridgeGame;
import bridge.Enum.BridgeGameInfo;

import java.util.List;

public class OutputView {
    String UP = BridgeGameInfo.UP.getWord();
    String DOWN = BridgeGameInfo.DOWN.getWord();
    String CORRECT = BridgeGameInfo.CORRECT.getWord();
    String WRONG = BridgeGameInfo.WRONG.getWord();
    String BLANK = BridgeGameInfo.BLANK.getWord();

    public void printMap(List<Boolean> matchResult,List<String> bridge) {
        printBridge(matchResult, bridge, UP);
        printBridge(matchResult, bridge, DOWN);
    }

    public void printBridge(List<Boolean> matchResult,List<String> bridge,String way) {
        System.out.print("[");
        printBridgeCell(matchResult,bridge,way);
        System.out.println("]");
    }

    public void printBridgeCell(List<Boolean> matchResult, List<String> bridge, String way) {
        for (int i = 0; i < matchResult.size(); i++) {
            printBridgeCellLoop(matchResult.get(i),bridge.get(i),way);
            printWall(i,matchResult);
        }
    }

    public void printBridgeCellLoop(boolean matchResult, String bridge, String way) {
        printEqual(matchResult,bridge,way);
        printNotEqual(matchResult,bridge,way);
    }

    public void printEqual(boolean matchResult, String bridge, String way) {
        if (bridge.equals(way)) {
            String correct = CORRECT;
            if (!matchResult) {
                correct = BLANK;
            }
            System.out.print(correct);
        }
    }

    public void printNotEqual(boolean matchResult, String bridge, String way) {
        if (!bridge.equals(way)) {
            String wrong = WRONG;
            if (matchResult) {
                wrong = BLANK;
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

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printReadBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printReadMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: " + BridgeGameInfo.UP.getWord() + ", 아래: " + BridgeGameInfo.DOWN.getWord() + ")");
    }

    public void printReadGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요 (재시도: " + BridgeGameInfo.RESTART.getWord() + ", 종료: " + BridgeGameInfo.QUIT.getWord() + ")");
    }
}
