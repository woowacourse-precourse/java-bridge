package bridge.view;

import bridge.BridgeGame;
import bridge.GameStatus;
import bridge.MoveCommand;
import bridge.MoveResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final char MOVE_SUCCESS = 'O';
    private static final char MOVE_FAIL = 'X';
    private static final char MOVE_BLANK = ' ';

    private List<Character> upperBridge;
    private List<Character> lowerBridge;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param moveResult
     */
    public void printMap(MoveResult moveResult) {
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();

        fillMapByStatus(moveResult);

        printBridge(upperBridge);
        printBridge(lowerBridge);
    }

    private void fillMapByStatus(MoveResult moveResult) {
        GameStatus gameStatus = moveResult.getMoveStatus();
        List<String> history = moveResult.getHistory();

        if (gameStatus == GameStatus.CORRECT || gameStatus == GameStatus.CONTINUE) {
            fillMap(history);
        }
        if (gameStatus == GameStatus.FAIL) {
            fillMapExceptLastValue(history);
            fillLastValue(history);
        }
    }

    private void fillMapExceptLastValue(List<String> history) {
        for (int idx = 0; idx < history.size() - 1; idx++) {
            fill(history, idx);
        }
    }

    private void fillMap(List<String> history) {
        for (int idx = 0; idx < history.size(); idx++) {
            fill(history, idx);
        }
    }

    private void fill(List<String> history, int idx) {
        char moveCommand = history.get(idx).charAt(0);
        if (moveCommand == MoveCommand.UP.getValue()) {
            upperBridge.add(MOVE_SUCCESS);
            lowerBridge.add(MOVE_BLANK);
        }
        if (moveCommand == MoveCommand.DOWN.getValue()) {
            upperBridge.add(MOVE_BLANK);
            lowerBridge.add(MOVE_SUCCESS);
        }
    }

    private void fillLastValue(List<String> history) {
        char lastChar = history.get(history.size() - 1).charAt(0);
        if (lastChar == MoveCommand.UP.getValue()) {
            upperBridge.add(MOVE_FAIL);
            lowerBridge.add(MOVE_BLANK);
        }
        if (lastChar == MoveCommand.DOWN.getValue()) {
            upperBridge.add(MOVE_BLANK);
            lowerBridge.add(MOVE_FAIL);
        }
    }

    private void printBridge(List<Character> bridge) {
        System.out.print("[");
        for (int i = 0; i < bridge.size() - 1; i++) {
            System.out.print(" " + bridge.get(i) + " |");
        }
        System.out.print(" " + bridge.get(bridge.size() - 1) + " ");
        System.out.print("]");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(MoveResult moveResult, BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(moveResult);
        System.out.println();

        System.out.println("게임 성공 여부: " + moveResult.getMoveStatus());
        System.out.println("총 시도한 횟수: " + bridgeGame.getTotalAttempt());
    }
}
