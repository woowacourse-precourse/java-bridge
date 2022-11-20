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
    public void printMap(Bridge bridge, int position, boolean isMovable) {
        List<String> crossedBridge = bridge.getCrossedBridge(position);

        printCrossedUp(crossedBridge, isMovable);
        printCrossedDown(crossedBridge, isMovable);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }


    private void printCrossedUp(List<String> crossedBridge, boolean isMovable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < crossedBridge.size() - 1; i++) {
            saveCrossedUpsideBridge(crossedBridge.get(i), stringBuilder);
            stringBuilder.append("|");
        }
        saveLastUpsideMove(crossedBridge, isMovable, stringBuilder);
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    private void saveLastUpsideMove(List<String> crossedBridge, boolean isMovable, StringBuilder stringBuilder) {
        if (isMovable) {
            saveCrossedUpsideBridge(crossedBridge.get(crossedBridge.size() - 1), stringBuilder);
            return;
        }
        if (crossedBridge.get(crossedBridge.size() - 1).equals(MOVING_UP)) {
            stringBuilder.append("   ");
        }
        if (!crossedBridge.get(crossedBridge.size() - 1).equals(MOVING_UP)) {
            stringBuilder.append(" X ");
        }
    }

    private void saveCrossedUpsideBridge(String block, StringBuilder stringBuilder) {
        if (block.equals(MOVING_UP)) {
            stringBuilder.append(" O ");
        }
        if (!block.equals(MOVING_UP)) {
            stringBuilder.append("   ");
        }
    }

    private void printCrossedDown(List<String> brid, boolean isMovable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < brid.size() - 1; i++) {
            saveCrossedDownsideBridge(brid.get(i), stringBuilder);
            stringBuilder.append("|");
        }
        saveLastDownsideMove(brid, isMovable, stringBuilder);
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    private void saveLastDownsideMove(List<String> brid, boolean isMovable, StringBuilder stringBuilder) {
        if (isMovable) {
            saveCrossedDownsideBridge(brid.get(brid.size() - 1), stringBuilder);
            return;
        }
        if (brid.get(brid.size() - 1).equals(MOVING_DOWN)) {
            stringBuilder.append("   ");
        }
        if (!brid.get(brid.size() - 1).equals(MOVING_DOWN)) {
            stringBuilder.append(" X ");
        }
    }

    private void saveCrossedDownsideBridge(String block, StringBuilder stringBuilder) {
        if (block.equals(MOVING_DOWN)) {
            stringBuilder.append(" O ");
        }
        if (!block.equals(MOVING_DOWN)) {
            stringBuilder.append("   ");
        }
    }
}
