package bridge;

import bridge.Setting.BridgeSideIndex;
import bridge.Setting.BridgeSidePrintIndex;
import bridge.Setting.OutputViewPrintEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> printMap(BridgeGame bridgeGame) {
        List<String> lines = new ArrayList<>();
        List<BridgeSideIndex> bridgeSideIndices = List.of(BridgeSideIndex.values());
        for (BridgeSideIndex bridgeSideIndex : bridgeSideIndices) {
            List<String> sideIndex = getSideIndex(bridgeSideIndex, bridgeGame);
            String sideString = getSideString(sideIndex);
            lines.add(sideString);
        }
        return lines;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public String getSideString(List<String> sideIndex){
        String sideString = String.join(OutputViewPrintEnum.OUTPUT_BRIDGE_SIDE_SEPARATOR.getMessage(), sideIndex);
        return OutputViewPrintEnum.OUTPUT_BRIDGE_SIDE.getMessage()
                .replace(OutputViewPrintEnum.CHANGE_STRING.getMessage(), sideString);
    }
    public List<String> getSideIndex(BridgeSideIndex bridgeSideIndex, BridgeGame bridgeGame) {
        List<String> sideIndex = new ArrayList<>();
        List<String> bridge = bridgeGame.getBridge();
        List<Boolean> bridgeCorrect = bridgeGame.getBridgeCorrect();
        for (int index = 0; index < bridgeCorrect.size(); index++) {
            String printEach = getPrintEach(bridgeSideIndex, bridge.get(index), bridgeCorrect.get(index));
            sideIndex.add(printEach);
        }
        return sideIndex;
    }

    public String getPrintEach(BridgeSideIndex bridgeSideIndex, String bridgeEach, boolean bridgeCorrectEach) {
        if (bridgeSideIndex.getLabel().equals(bridgeEach)) {
            if (bridgeCorrectEach) {
                return BridgeSidePrintIndex.CORRECT.getLabel();
            }
            return BridgeSidePrintIndex.WRONG.getLabel();
        }
        return BridgeSidePrintIndex.BLANK.getLabel();
    }
}
