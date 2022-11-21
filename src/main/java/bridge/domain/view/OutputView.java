package bridge.domain.view;

import bridge.constants.GuideMessage;
import bridge.domain.model.CrossBridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    CrossBridge crossBridge = new CrossBridge();

    public void printGuideMessage(GuideMessage guideMessage) {
        System.out.print(guideMessage.getMessage());
    }

    public void printMap() {
        String upMap = printMapByLine(1);
        String downMap = printMapByLine(0);
        System.out.println(upMap);
        System.out.println(downMap);
    }

    // line: 1==up / 0==down
    public String printMapByLine(int line) {
        StringBuilder result = new StringBuilder("[ ");
        int index = 0;
        for (; index < crossBridge.getCrossBridgeSize() - 1; index++) {
            result.append(crossBridge.getCrossBridgeIndex(index).getWay(line));
            result.append(" | ");
        }
        result.append(crossBridge.getCrossBridgeIndex(index).getWay(line));
        result.append(" ]");
        return result.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        printGuideMessage(GuideMessage.FINAL_RESULT_MESSAGE);
        printMap();
        System.out.println();
        printSuccessOrFailure();
        printTotalTry();
    }

    public void printSuccessOrFailure() {
        printGuideMessage(GuideMessage.SUCCESS_OR_FAILURE_MESSAGE);
        System.out.println(crossBridge.getSuccess());
    }

    public void printTotalTry() {
        printGuideMessage(GuideMessage.TOTAL_TRY_MESSAGE);
        System.out.println(crossBridge.getTotalTry());
    }
}
