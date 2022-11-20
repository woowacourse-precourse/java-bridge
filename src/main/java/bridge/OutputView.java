package bridge;

import java.util.ArrayList;
import java.util.List;

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
    public void printMap(Bridge bridge, int position) {
        List<String> crossedBridge = bridge.getCrossedBridge(position);
        List<Integer> crossedUpside = new ArrayList<>();
        List<Integer> crossedDownside = new ArrayList<>();
        for (String block : crossedBridge) {
            saveCrossedRecord(block, crossedUpside, crossedDownside);
        }
        printCrossedRecord(crossedUpside, crossedDownside);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private void saveCrossedRecord(String block, List<Integer> crossedUpside, List<Integer> crossedDownside) {
        if (block.equals(MOVING_UP)) {
            crossedUpside.add(1);
            crossedDownside.add(0);
            return;
        }
        crossedUpside.add(0);
        crossedDownside.add(1);
    }

    private void printCrossedRecord(List<Integer> crossedUpside, List<Integer> crossedDownside) {
        StringBuilder crossedUpsideStringBuilder = new StringBuilder();
        StringBuilder crossedDownsideStringBuilder = new StringBuilder();
        saveOutViewOfRecord(crossedUpside, crossedUpsideStringBuilder);
        saveOutViewOfRecord(crossedDownside, crossedDownsideStringBuilder);
        System.out.println(crossedUpsideStringBuilder);
        System.out.println(crossedDownsideStringBuilder);
    }

    private void saveOutViewOfRecord(List<Integer> crossedUpside, StringBuilder stringBuilder) {
        stringBuilder.append("[");
        for (int i = 0; i < crossedUpside.size(); i++) {
            if (crossedUpside.get(i) == 1 && i != crossedUpside.size() - 1) {
                stringBuilder.append(" O ");
            }
            if (crossedUpside.get(i) == 0 && i != crossedUpside.size() - 1) {
                stringBuilder.append("   ");
            }
            if (i < crossedUpside.size() - 1) {
                stringBuilder.append("|");
            }
            if (i == crossedUpside.size() - 1 && crossedUpside.get(i) == 0) {
                stringBuilder.append(" X ");
            }
            if (i == crossedUpside.size() - 1 && crossedUpside.get(i) == 1) {
                stringBuilder.append("   ");
            }
        }
        stringBuilder.append("]");
    }
}
