package bridge.view;

import bridge.domain.GameResult;

import java.util.List;

import static bridge.utils.ViewMessage.*;

public class OutputView {

    public void printMap(GameResult gameResult) {
        System.out.println(OUTPUT_FINAL_RESULT);
        printCurrentBridgeMap(gameResult.getUpSideResult());
        printCurrentBridgeMap(gameResult.getDownSideResult());
        System.out.println();
    }

    public void printCurrentBridgeMap(List<String> bridgeResult) {
        String result = String.join(SEPARATOR_OF_BRIDGE, bridgeResult);
        System.out.println(START_OF_BRIDGE + result + END_OF_BRIDGE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
