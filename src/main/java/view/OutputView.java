package view;

import bridge.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final BridgeGame bridgeGame;
    private final List<String> upOutputBoard;
    private final List<String> downOutputBoard;

    public OutputView(BridgeGame bridgeGame, List<String> outputBoard, List<String> downOutputBoard) {
        this.bridgeGame = bridgeGame;
        this.upOutputBoard = outputBoard;
        this.downOutputBoard = downOutputBoard;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int movedPosition, String moving, List<String> bridge) {
        goUpDown(movedPosition, moving, bridge);

        NotGoUpDown(movedPosition, moving, bridge);
    }

    private void NotGoUpDown(int movedPosition, String moving, List<String> bridge) {
        if (bridgeGame.move(movedPosition, moving, bridge)) {
            if (!bridge.get(movedPosition).equals(moving) && moving.equals("U")) {
                if (upOutputBoard.isEmpty()) printWhenFirstNotGoUp();
                if (!upOutputBoard.isEmpty()) printWhenNotGoUp();
            }
            if (!bridge.get(movedPosition).equals(moving) && moving.equals("D")) {
                if (upOutputBoard.isEmpty()) printWhenFirstNotGoDown();
                if (!upOutputBoard.isEmpty()) printWhenNotGoDown();
            }
        }
    }

    private void goUpDown(int movedPosition, String moving, List<String> bridge) {
        if (bridgeGame.move(movedPosition, moving, bridge)) {
            if (bridge.get(movedPosition).equals(moving) && moving.equals("U")) {
                if (upOutputBoard.isEmpty()) printWhenFirstGoUp();
                if (!upOutputBoard.isEmpty()) printWhenGoUp();
            }
            if (bridge.get(movedPosition).equals(moving) && moving.equals("D")) {
                if (upOutputBoard.isEmpty()) printWhenFirstGoDown();
                if (!upOutputBoard.isEmpty()) printWhenGoDown();
            }
        }
    }

    private void printWhenNotGoDown() {
        upOutputBoard.remove("]");
        upOutputBoard.add("|");
        upOutputBoard.add(" ");
        upOutputBoard.add(" ");
        upOutputBoard.add(" ");
        upOutputBoard.add("]");
        downOutputBoard.remove("]");
        downOutputBoard.add("|");
        downOutputBoard.add(" ");
        downOutputBoard.add("X");
        downOutputBoard.add(" ");
        downOutputBoard.add("]");
    }

    private void printWhenFirstNotGoDown() {
        upOutputBoard.add("[");
        upOutputBoard.add(" ");
        upOutputBoard.add(" ");
        upOutputBoard.add(" ");
        upOutputBoard.add("]");
        downOutputBoard.add("[");
        downOutputBoard.add(" ");
        downOutputBoard.add("X");
        downOutputBoard.add(" ");
        downOutputBoard.add("]");
    }

    private void printWhenNotGoUp() {
        upOutputBoard.remove("]");
        upOutputBoard.add("|");
        upOutputBoard.add(" ");
        upOutputBoard.add("X");
        upOutputBoard.add(" ");
        upOutputBoard.add("]");
        downOutputBoard.remove("]");
        downOutputBoard.add("|");
        downOutputBoard.add(" ");
        downOutputBoard.add(" ");
        downOutputBoard.add(" ");
        downOutputBoard.add("]");
    }

    private void printWhenFirstNotGoUp() {
        upOutputBoard.add("[");
        upOutputBoard.add(" ");
        upOutputBoard.add("X");
        upOutputBoard.add(" ");
        upOutputBoard.add("]");
        downOutputBoard.add("[");
        downOutputBoard.add(" ");
        downOutputBoard.add(" ");
        downOutputBoard.add(" ");
        downOutputBoard.add("]");
    }

    private void printWhenGoDown() {
        upOutputBoard.remove("]");
        upOutputBoard.add("|");
        upOutputBoard.add(" ");
        upOutputBoard.add(" ");
        upOutputBoard.add(" ");
        upOutputBoard.add("]");
        downOutputBoard.remove("]");
        downOutputBoard.add("|");
        downOutputBoard.add(" ");
        downOutputBoard.add("O");
        downOutputBoard.add(" ");
        downOutputBoard.add("]");
    }

    private void printWhenFirstGoDown() {
        upOutputBoard.add("[");
        upOutputBoard.add(" ");
        upOutputBoard.add(" ");
        upOutputBoard.add(" ");
        upOutputBoard.add("]");
        downOutputBoard.add("[");
        downOutputBoard.add(" ");
        downOutputBoard.add("O");
        downOutputBoard.add(" ");
        downOutputBoard.add("]");
    }

    private void printWhenGoUp() {
        upOutputBoard.remove("]");
        upOutputBoard.add("|");
        upOutputBoard.add(" ");
        upOutputBoard.add("O");
        upOutputBoard.add(" ");
        upOutputBoard.add("]");
        downOutputBoard.remove("]");
        downOutputBoard.add("|");
        downOutputBoard.add(" ");
        downOutputBoard.add(" ");
        downOutputBoard.add(" ");
        downOutputBoard.add("]");
    }

    private void printWhenFirstGoUp() {
        upOutputBoard.add("[");
        upOutputBoard.add(" ");
        upOutputBoard.add("O");
        upOutputBoard.add(" ");
        upOutputBoard.add("]");
        downOutputBoard.add("[");
        downOutputBoard.add(" ");
        downOutputBoard.add(" ");
        downOutputBoard.add(" ");
        downOutputBoard.add("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
