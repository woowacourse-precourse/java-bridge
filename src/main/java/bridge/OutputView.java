package bridge;

import bridge.BridgeGame.STATE;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public String getBlockResult(String bridgeBlock, String movesBlock, String direction) {
        if (!direction.equals(movesBlock)) {
            return " ";
        }
        if (bridgeBlock.equals(movesBlock)) {
            return "O";
        }
        return "X";
    }

    public void printOneLine(List<String> bridge, List<String> moves, String direction) {
        System.out.print("[ ");
        System.out.print(getBlockResult(bridge.get(0), moves.get(0), direction));

        for (int i = 1; i < moves.size(); i++) {
            System.out.print(" | ");
            System.out.print(getBlockResult(bridge.get(i), moves.get(i), direction));
        }
        System.out.print(" ]\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> moves) {
        printOneLine(bridge, moves, "U");
        printOneLine(bridge, moves, "D");
    }

    public String getStateString(BridgeGame game) {
        String result = "";
        if (game.getState() == STATE.FAILED) {
            result = "실패";
        }
        if (game.getState() == STATE.SUCCESS) {
            result = "성공";
        }
        return result;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game, int retries) {
        System.out.println("최종 게임 결과");
        printMap(game.getBridge(), game.getMoves());
        System.out.printf("게임 성공 여부: %s\n", getStateString(game));
        System.out.printf("총 시도한 횟수: %d\n", retries);
    }
}
