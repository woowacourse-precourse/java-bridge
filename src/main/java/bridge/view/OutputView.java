package bridge.view;

import bridge.BridgeGame;

import java.util.List;

import static bridge.constant.GameKeyboard.*;

public class OutputView {
    public static final int NEXT_INDEX = 1;
    private String initUpperBridgeMap = "[";
    private String initDownBridgeMap = "[";

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
        if (answerBridge.contains(WRONG_ANSWER.letter())) {
            printBridgeWithX(currentBridgeIndex, answerBridge);
        }

        if (isCorrectAnswer(answerBridge)) {
            printCorrectBridge(currentBridgeIndex, answerBridge);
        }
    }

    private static boolean isCorrectAnswer(List<String> answerBridge) {
        return !answerBridge.contains(WRONG_ANSWER.letter());
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
        if (nextIndexMovingMark.equals(UP.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + "| X ";
            initDownBridgeMap = initDownBridgeMap + "|   ";
        }
        if (nextIndexMovingMark.equals(DOWN.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + "|   ";
            initDownBridgeMap = initDownBridgeMap + "| X ";
        }
    }

    private void printWrongFirstBridge(int currentBridgeIndex, List<String> answerBridge) {
        String nextIndexMovingMark = answerBridge.get(currentBridgeIndex + NEXT_INDEX);
        if (nextIndexMovingMark.equals(UP.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + " X ";
            initDownBridgeMap = initDownBridgeMap + "   ";
        }
        if (nextIndexMovingMark.equals(DOWN.letter())) {
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
        if (currentIndexMovingMark.equals(UP.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + "| O ";
            initDownBridgeMap = initDownBridgeMap + "|   ";
        }
        if (currentIndexMovingMark.equals(DOWN.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + "|   ";
            initDownBridgeMap = initDownBridgeMap + "| O ";
        }
    }

    private void printCorrectFirstBridge(int currentBridgeIndex, List<String> answerBridge) {
        String currentIndexMovingMark = answerBridge.get(currentBridgeIndex);
        if (currentIndexMovingMark.equals(UP.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + " O ";
            initDownBridgeMap = initDownBridgeMap + "   ";
        }
        if (currentIndexMovingMark.equals(DOWN.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + "   ";
            initDownBridgeMap = initDownBridgeMap + " O ";
        }
    }

    public void printResult(String restartMessage, int attemptCount) {
        if (restartMessage.equals(QUIT.letter())) {
            System.out.println("최종 게임 결과");
            printClose();
            System.out.println();
            System.out.println("게임 성공 여부: 실패");
            System.out.println("총 시도한 횟수: " + attemptCount);
        }
    }

    public void retryBridgeMap() {
        initUpperBridgeMap = "[";
        initDownBridgeMap = "[";
    }

    public void printResult(BridgeGame bridgeGame) {
        if (!bridgeGame.getMyAnswerBridges().contains("X")) {
            System.out.println("최종 게임 결과");
            printClose();
            System.out.println();
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + bridgeGame.getAttemptCount());
        }
    }

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
