package bridge.view;

import bridge.constant.Constant;
import bridge.constant.Message;
import bridge.enums.BridgeSign;
import bridge.enums.SuccessOrFail;
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
    public void printMap(List<Integer> bridgeMap, boolean isRightLastBridgePick) {
        printOneSideBridge(bridgeMap, isRightLastBridgePick, Constant.UPPER_BRIDGE);
        printOneSideBridge(bridgeMap, isRightLastBridgePick, Constant.LOWER_BRIDGE);
        System.out.println();
    }

    private void printOneSideBridge(List<Integer> bridgeMap, boolean isRightLastBridgePick, int bridgeTypeToPrint) {
        List<String> bridgesSign = collectSign(bridgeMap, isRightLastBridgePick, bridgeTypeToPrint);
        String oneSideBridgeToPrint = String.join(Message.BRIDGE_JOINING_DELIMITER, bridgesSign);
        System.out.printf(Message.BRIDGE_MAP_FORM, oneSideBridgeToPrint);
    }

    private List<String> collectSign(List<Integer> bridgeMap, boolean isRightLastBridgePick, int bridgeTypeToPrint) {
        List<String> bridgesSign = new ArrayList<>();
        for (int position = Constant.INITIAL_INDEX; position < bridgeMap.size(); position++) {
            int currentBridgeType = bridgeMap.get(position);
            boolean isEdge = position == (bridgeMap.size() - Constant.INDEX_ZEROING_NUMBER);
            boolean isRightCurrentBridgePick = currentBridgeType == bridgeTypeToPrint;
            BridgeSign bridgeSign = BridgeSign.create(isEdge, isRightCurrentBridgePick, isRightLastBridgePick);
            bridgesSign.add(bridgeSign.getSign());
        }
        return bridgesSign;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Integer> bridgeMap, SuccessOrFail successOrFail, int retryCount) {
        System.out.println(Message.GAME_RESULT);
        printMap(bridgeMap, successOrFail.isSuccess());
        System.out.printf(Message.SUCCESS_OR_NOT_FORM, successOrFail.getKorean());
        System.out.printf(Message.RETRY_COUNT_FORM, retryCount);
    }
}
