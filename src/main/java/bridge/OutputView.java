package bridge;

import java.util.List;

/**
 * 패키지 변경가능. 메서드이름 변경불가. 인자와 반환타입은 필요에 따라 추가 변경 가능.
 * /**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private String initUpperBridgeMap = "[";
    private String initDownBridgeMap = "[";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame, int currentBridgeIndex) {
        List<String> answerBridge = bridgeGame.getMyAnswerBridges();
        checkXMark(answerBridge, currentBridgeIndex);
        printClose();
    }

    private void printClose() {
        System.out.println(initUpperBridgeMap + "]");
        System.out.println(initDownBridgeMap + "]");
    }

    private void checkXMark(List<String> answerBridge, int currentBridgeIndex) {
        if (answerBridge.contains("X")) {
            printBridgeWithX(currentBridgeIndex, answerBridge);
        }

        if (!answerBridge.contains("X")) {
            printCorrectBridge(currentBridgeIndex, answerBridge);
        }
    }

    private void printBridgeWithX(int currentBridgeIndex, List<String> answerBridge) {
        if (isFirstBridge(currentBridgeIndex)) {
            printWrongFirstBridge(currentBridgeIndex, answerBridge);
        }

        if (isNotFirstBridge(currentBridgeIndex)) {
            printWrongAllBridge(currentBridgeIndex, answerBridge);
        }
    }

    private void printWrongAllBridge(int currentBridgeIndex, List<String> answerBridge) {
        String nextIndexMovingMark = answerBridge.get(currentBridgeIndex + 1);
        if (nextIndexMovingMark.equals("U")) {
            initUpperBridgeMap = initUpperBridgeMap + "| X ";
            initDownBridgeMap = initDownBridgeMap + "|   ";
        }
        if (nextIndexMovingMark.equals("D")) {
            initUpperBridgeMap = initUpperBridgeMap + "|   ";
            initDownBridgeMap = initDownBridgeMap + "| X ";
        }
    }

    private void printWrongFirstBridge(int currentBridgeIndex, List<String> answerBridge) {
        String nextIndexMovingMark = answerBridge.get(currentBridgeIndex + 1);
        if (nextIndexMovingMark.equals("U")) {
            initUpperBridgeMap = initUpperBridgeMap + " X ";
            initDownBridgeMap = initDownBridgeMap + "   ";
        }
        if (nextIndexMovingMark.equals("D")) {
            initUpperBridgeMap = initUpperBridgeMap + "   ";
            initDownBridgeMap = initDownBridgeMap + " X ";
        }
    }

    private void printCorrectBridge(int currentBridgeIndex, List<String> answerBridge) {
        if (isFirstBridge(currentBridgeIndex)) {
            printCorrectFirstBridge(currentBridgeIndex, answerBridge);
        }

        if (isNotFirstBridge(currentBridgeIndex)) {
            printCorrectAllBridge(currentBridgeIndex, answerBridge);
        }
    }

    private static boolean isNotFirstBridge(int currentBridgeIndex) {
        return currentBridgeIndex != 0;
    }

    private static boolean isFirstBridge(int currentBridgeIndex) {
        return currentBridgeIndex == 0;
    }

    private void printCorrectAllBridge(int currentBridgeIndex, List<String> answerBridge) {
        String currentIndexMovingMark = answerBridge.get(currentBridgeIndex);
        if (currentIndexMovingMark.equals("U")) {
            initUpperBridgeMap = initUpperBridgeMap + "| O ";
            initDownBridgeMap = initDownBridgeMap + "|   ";
        }
        if (currentIndexMovingMark.equals("D")) {
            initUpperBridgeMap = initUpperBridgeMap + "|   ";
            initDownBridgeMap = initDownBridgeMap + "| O ";
        }
    }

    private void printCorrectFirstBridge(int currentBridgeIndex, List<String> answerBridge) {
        String currentIndexMovingMark = answerBridge.get(currentBridgeIndex);
        if (currentIndexMovingMark.equals("U")) {
            initUpperBridgeMap = initUpperBridgeMap + " O ";
            initDownBridgeMap = initDownBridgeMap + "   ";
        }
        if (currentIndexMovingMark.equals("D")) {
            initUpperBridgeMap = initUpperBridgeMap + "   ";
            initDownBridgeMap = initDownBridgeMap + " O ";
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
    }
}
