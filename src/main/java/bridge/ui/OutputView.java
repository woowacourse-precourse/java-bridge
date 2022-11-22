package bridge.ui;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;

import java.util.List;

import static bridge.util.Constant.MOVING_DOWN;
import static bridge.util.Constant.MOVING_UP;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(BridgeGame bridgeGame, boolean isMovable) {
        int position = bridgeGame.getPosition();
        Bridge bridge = bridgeGame.getBridge();
        List<String> crossedBridge = bridge.getCrossedBridge(position);

        printCrossedUp(crossedBridge, isMovable, new StringBuilder());
        printCrossedDown(crossedBridge, isMovable, new StringBuilder());
        System.out.println(" ");
    }

    public void printResult(BridgeGame bridgeGame, boolean isSuccess) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame, isSuccess);
        if (isSuccess) {
            printIsSuccess(true, bridgeGame.getAttempts());
            return;
        }
        printIsSuccess(false, bridgeGame.getAttempts());
    }

    private void printCrossedUp(List<String> crossedUpRecords, boolean isMovable, StringBuilder recordForPrint) {
        recordForPrint.append("[");
        for (int i = 0; i < crossedUpRecords.size() - 1; i++) {
            saveCrossedUp(crossedUpRecords.get(i), recordForPrint);
            recordForPrint.append("|");
        }
        saveLastCrossedUp(crossedUpRecords.get(crossedUpRecords.size() - 1), isMovable, recordForPrint);
        recordForPrint.append("]");
        System.out.println(recordForPrint);
    }

    private void saveCrossedUp(String block, StringBuilder recordForPrint) {
        if (block.equals(MOVING_UP)) {
            recordForPrint.append(" O ");
        }
        if (!block.equals(MOVING_UP)) {
            recordForPrint.append("   ");
        }
    }

    private void saveLastCrossedUp(String lastMove, boolean isMovable, StringBuilder recordForPrint) {
        if (isMovable) {
            saveCrossedUp(lastMove, recordForPrint);
            return;
        }
        saveUnmovableLastUpBlock(lastMove, recordForPrint);
    }

    private void saveUnmovableLastUpBlock(String lastBlock, StringBuilder recordForPrint) {
        if (lastBlock.equals(MOVING_UP)) {
            recordForPrint.append("   ");
        }
        if (!lastBlock.equals(MOVING_UP)) {
            recordForPrint.append(" X ");
        }
    }

    private void printCrossedDown(List<String> crossedDownRecords, boolean isMovable, StringBuilder recordForPrint) {
        recordForPrint.append("[");
        for (int i = 0; i < crossedDownRecords.size() - 1; i++) {
            saveCrossedDown(crossedDownRecords.get(i), recordForPrint);
            recordForPrint.append("|");
        }
        saveLastCrossedDown(crossedDownRecords.get(crossedDownRecords.size() - 1), isMovable, recordForPrint);
        recordForPrint.append("]");
        System.out.println(recordForPrint);
    }

    private void saveCrossedDown(String block, StringBuilder recordForPrint) {
        if (block.equals(MOVING_DOWN)) {
            recordForPrint.append(" O ");
        }
        if (!block.equals(MOVING_DOWN)) {
            recordForPrint.append("   ");
        }
    }

    private void saveLastCrossedDown(String lastMove, boolean isMovable, StringBuilder recordForPrint) {
        if (isMovable) {
            saveCrossedDown(lastMove, recordForPrint);
            return;
        }
        saveUnmovableLastDownBlock(lastMove, recordForPrint);
    }

    private void saveUnmovableLastDownBlock(String lastBlock, StringBuilder recordForPrint) {
        if (lastBlock.equals(MOVING_UP)) {
            recordForPrint.append(" X ");
        }
        if (!lastBlock.equals(MOVING_UP)) {
            recordForPrint.append("   ");
        }
    }

    private void printIsSuccess(boolean isSuccess, int attempts) {
        if (isSuccess) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + attempts);
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + attempts);
    }
}
