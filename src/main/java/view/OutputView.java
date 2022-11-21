package view;

import bridge.BridgeGame;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private final BridgeGame bridgeGame;
    public final List<String> upOutputBoard;
    public final List<String> downOutputBoard;

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

        System.out.println();
    }

    private void NotGoUpDown(int movedPosition, String moving, List<String> bridge) {
        if (!bridgeGame.move(movedPosition, moving, bridge)) {
            enterCommandNotGoUp(moving);
        }
    }

    private void enterCommandNotGoUp(String moving) {
        if (moving.equals("U")) {
            if (!upOutputBoard.isEmpty()) printWhenNotGoUp();
            if (upOutputBoard.isEmpty()) printWhenFirstNotGoUp();
        }
        if (moving.equals("D")) {
            if (!upOutputBoard.isEmpty()) printWhenNotGoDown();
            if (upOutputBoard.isEmpty()) printWhenFirstNotGoDown();
        }
    }

    private void goUpDown(int movedPosition, String moving, List<String> bridge) {
        if (bridgeGame.move(movedPosition, moving, bridge)) {
            enterCommandGoUp(movedPosition, moving, bridge);
        }
    }

    private void enterCommandGoUp(int movedPosition, String moving, List<String> bridge) {
        if (bridge.get(movedPosition).equals(moving) && moving.equals("U")) {
            if (!upOutputBoard.isEmpty()) printWhenGoUp();
            if (upOutputBoard.isEmpty()) printWhenFirstGoUp();
        }
        if (bridge.get(movedPosition).equals(moving) && moving.equals("D")) {
            if (!upOutputBoard.isEmpty()) printWhenGoDown();
            if (upOutputBoard.isEmpty()) printWhenFirstGoDown();
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
        printBoard();
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
        printBoard();
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
        printBoard();
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
        printBoard();
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
        printBoard();
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
        printBoard();
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
        printBoard();
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
        printBoard();
    }

    private void printBoard() {
        System.out.println(upOutputBoard.stream().collect(Collectors.joining()));
        System.out.println(downOutputBoard.stream().collect(Collectors.joining()));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean success, int count) {
        System.out.println("최종 게임 결과");
        System.out.println(upOutputBoard.stream().collect(Collectors.joining()));
        System.out.println(downOutputBoard.stream().collect(Collectors.joining()));
        System.out.println();
        if (success) System.out.println("게임 성공 여부: " + SUCCESS);
        if (!success) System.out.println("게임 성공 여부: " + FAIL);
        System.out.println("총 시도한 횟수: " + count);
    }
}
