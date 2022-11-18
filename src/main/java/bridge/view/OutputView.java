package bridge.view;

import bridge.AttemptCount;
import bridge.BridgeGame;

import java.util.List;

import static bridge.constant.GameKeyboard.*;

public class OutputView {
    private String initUpperBridgeMap = "[";
    private String initDownBridgeMap = "[";

    public void printMap(BridgeGame bridgeGame, int currentBridgeIndex) {
        checkXMark(bridgeGame, currentBridgeIndex);
        printClose();
    }

    private void printClose() {
        System.out.println(initUpperBridgeMap + "]");
        System.out.println(initDownBridgeMap + "]");
    }

    private void checkXMark(BridgeGame bridgeGame, int currentBridgeIndex) {
        if (bridgeGame.isSelectedWrongBridge()) {
            printBridgeWithX(currentBridgeIndex, bridgeGame);
        }

        if (bridgeGame.isSelectedCorrectBridge()) {
            printCorrectBridge(currentBridgeIndex, bridgeGame);
        }
    }

    private void printBridgeWithX(int currentBridgeIndex, BridgeGame bridgeGame) {
        if (isFirstBridge(currentBridgeIndex)) {
            printWrongFirstBridge(currentBridgeIndex, bridgeGame);
        }

        if (isNotFirstBridge(currentBridgeIndex)) {
            printWrongAllBridge(currentBridgeIndex, bridgeGame);
        }
    }

    private void printWrongAllBridge(int currentBridgeIndex, BridgeGame bridgeGame) {
        String nextIndexMovingMark = bridgeGame.getWrongMovingMark(currentBridgeIndex);
        if (nextIndexMovingMark.equals(UP.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + "| X ";
            initDownBridgeMap = initDownBridgeMap + "|   ";
        }
        if (nextIndexMovingMark.equals(DOWN.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + "|   ";
            initDownBridgeMap = initDownBridgeMap + "| X ";
        }
    }

    private void printWrongFirstBridge(int currentBridgeIndex, BridgeGame bridgeGame) {
        String nextIndexMovingMark = bridgeGame.getWrongMovingMark(currentBridgeIndex);
        if (nextIndexMovingMark.equals(UP.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + " X ";
            initDownBridgeMap = initDownBridgeMap + "   ";
        }
        if (nextIndexMovingMark.equals(DOWN.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + "   ";
            initDownBridgeMap = initDownBridgeMap + " X ";
        }
    }

    private void printCorrectBridge(int currentBridgeIndex, BridgeGame bridgeGame) {
        if (isFirstBridge(currentBridgeIndex)) {
            printCorrectFirstBridge(currentBridgeIndex, bridgeGame);
        }

        if (isNotFirstBridge(currentBridgeIndex)) {
            printCorrectAllBridge(currentBridgeIndex, bridgeGame);
        }
    }

    private static boolean isNotFirstBridge(int currentBridgeIndex) {
        return currentBridgeIndex != 0;
    }

    private static boolean isFirstBridge(int currentBridgeIndex) {
        return currentBridgeIndex == 0;
    }

    private void printCorrectAllBridge(int currentBridgeIndex, BridgeGame bridgeGame) {
        String currentIndexMovingMark = bridgeGame.getCorrectMovingMark(currentBridgeIndex);
        if (currentIndexMovingMark.equals(UP.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + "| O ";
            initDownBridgeMap = initDownBridgeMap + "|   ";
        }
        if (currentIndexMovingMark.equals(DOWN.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + "|   ";
            initDownBridgeMap = initDownBridgeMap + "| O ";
        }
    }

    private void printCorrectFirstBridge(int currentBridgeIndex, BridgeGame bridgeGame) {
        String currentIndexMovingMark = bridgeGame.getCorrectMovingMark(currentBridgeIndex);
        if (currentIndexMovingMark.equals(UP.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + " O ";
            initDownBridgeMap = initDownBridgeMap + "   ";
        }
        if (currentIndexMovingMark.equals(DOWN.letter())) {
            initUpperBridgeMap = initUpperBridgeMap + "   ";
            initDownBridgeMap = initDownBridgeMap + " O ";
        }
    }

    public void printResult(String restartMessage, AttemptCount gameAttemptCount) {
        if (restartMessage.equals(QUIT.letter())) {
            System.out.println("최종 게임 결과");
            printClose();
            System.out.println();
            System.out.println("게임 성공 여부: 실패");
            System.out.println("총 시도한 횟수: " + gameAttemptCount.getAttemptCount());
        }
    }

    public void retryBridgeMap() {
        initUpperBridgeMap = "[";
        initDownBridgeMap = "[";
    }

    public void printResult(BridgeGame bridgeGame, AttemptCount gameAttemptCount) {
        if (bridgeGame.isSelectedCorrectBridge()) {
            System.out.println("최종 게임 결과");
            printClose();
            System.out.println();
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + gameAttemptCount.getAttemptCount());
        }
    }

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
