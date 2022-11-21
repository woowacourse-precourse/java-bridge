package bridge;

import java.util.List;

import static bridge.Constant.MOVING_DOWN;
import static bridge.Constant.MOVING_UP;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame, boolean isMovable) {
        int position = bridgeGame.getPosition();
        Bridge bridge = bridgeGame.getBridge();
        List<String> crossedBridge = bridge.getCrossedBridge(position);

        printCrossedUp(crossedBridge, isMovable);
        printCrossedDown(crossedBridge, isMovable);
        System.out.println(" ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, boolean isSuccess) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame, isSuccess);
        if (isSuccess) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + bridgeGame.getAttempts());
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + bridgeGame.getAttempts());
    }


    private void printCrossedUp(List<String> crossedUpsideRecords, boolean isMovable) {
        StringBuilder recordForPrint = new StringBuilder();
        recordForPrint.append("[");
        for (int i = 0; i < crossedUpsideRecords.size() - 1; i++) {
            saveCrossedUpsideBridge(crossedUpsideRecords.get(i), recordForPrint);
            recordForPrint.append("|");
        }
        saveLastUpsideMove(crossedUpsideRecords, isMovable, recordForPrint);
        recordForPrint.append("]");
        System.out.println(recordForPrint);
    }

    private void saveLastUpsideMove(List<String> crossedUpsideRecords, boolean isMovable, StringBuilder recordForPrint) {
        if (isMovable) {
            saveCrossedUpsideBridge(crossedUpsideRecords.get(crossedUpsideRecords.size() - 1), recordForPrint);
            return;
        }
        if (crossedUpsideRecords.get(crossedUpsideRecords.size() - 1).equals(MOVING_UP)) {
            recordForPrint.append("   ");
        }
        if (!crossedUpsideRecords.get(crossedUpsideRecords.size() - 1).equals(MOVING_UP)) {
            recordForPrint.append(" X ");
        }
    }

    private void saveCrossedUpsideBridge(String block, StringBuilder recordForPrint) {
        if (block.equals(MOVING_UP)) {
            recordForPrint.append(" O ");
        }
        if (!block.equals(MOVING_UP)) {
            recordForPrint.append("   ");
        }
    }

    private void printCrossedDown(List<String> crossedDownsideRecords, boolean isMovable) {
        StringBuilder recordForPrint = new StringBuilder();
        recordForPrint.append("[");
        for (int i = 0; i < crossedDownsideRecords.size() - 1; i++) {
            saveCrossedDownsideBridge(crossedDownsideRecords.get(i), recordForPrint);
            recordForPrint.append("|");
        }
        saveLastDownsideMove(crossedDownsideRecords, isMovable, recordForPrint);
        recordForPrint.append("]");
        System.out.println(recordForPrint);
    }

    private void saveLastDownsideMove(List<String> crossedDownsideRecords, boolean isMovable, StringBuilder recordForPrint) {
        if (isMovable) {
            saveCrossedDownsideBridge(crossedDownsideRecords.get(crossedDownsideRecords.size() - 1), recordForPrint);
            return;
        }
        if (crossedDownsideRecords.get(crossedDownsideRecords.size() - 1).equals(MOVING_DOWN)) {
            recordForPrint.append("   ");
        }
        if (!crossedDownsideRecords.get(crossedDownsideRecords.size() - 1).equals(MOVING_DOWN)) {
            recordForPrint.append(" X ");
        }
    }

    private void saveCrossedDownsideBridge(String block, StringBuilder recordForPrint) {
        if (block.equals(MOVING_DOWN)) {
            recordForPrint.append(" O ");
        }
        if (!block.equals(MOVING_DOWN)) {
            recordForPrint.append("   ");
        }
    }
}
