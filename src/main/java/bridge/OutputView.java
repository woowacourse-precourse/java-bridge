package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        List<String> up = makePrintForm(bridgeGame, "U");
        List<String> down = makePrintForm(bridgeGame, "D");

        System.out.println("[ " + String.join(" | ", up) + " ]");
        System.out.println("[ " + String.join(" | ", down) + " ]");
        System.out.println();
    }

    private List<String> makePrintForm(BridgeGame bridgeGame, String direction) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < bridgeGame.getTurn(); i++) {
            String mark = getMark(bridgeGame, direction, i);
            result.add(mark);
        }
        return result;
    }

    private String getMark(BridgeGame bridgeGame, String direction, int i) {
        List<String> bridge = bridgeGame.getBridge();
        int turn = bridgeGame.getTurn();
        if (i == turn - 1 && bridgeGame.isDead()) {
            if (!direction.equals(bridge.get(i)))
                return "X";
            return " ";
        }
        if (direction.equals(bridge.get(i))) return "O";
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        System.out.println("게임 성공 여부: " + clearString(bridgeGame.clear()));
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }

    private String clearString(boolean clear) {
        if (clear) return "성공";
        return "실패";
    }
}
