package bridge.View;

import bridge.BridgeGame;
import bridge.BridgeMap;

import java.util.ArrayList;
import java.util.List;

import static bridge.View.Message.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeMap bridgeMap) {
        for (int i = 1; i >= 0; i--) {
            List<String> block = new ArrayList<>();
            for (List<String> partition : bridgeMap.getMap())
                block.add(partition.get(i));

            String map = String.join(" | ", block);
            System.out.println(OPEN_BRACKET.getMessage() + map + CLOSED_BRACKET.getMessage());
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(RESULT_MESSAGE.getMessage());
        printMap(bridgeGame.getBridgeMap());
        System.out.print(SUCCESS_OR_FAILURE_MESSAGE.getMessage());
        String result = checkResult(bridgeGame);
        System.out.println(result);
        System.out.print(TOTAL_ROUND_MESSAGE.getMessage());
        System.out.println(bridgeGame.getRound());
    }

    String checkResult(BridgeGame bridgeGame) {
        if (bridgeGame.checkSuccess())
            return SUCCESS_MESSAGE.getMessage();
        return FAILURE_MESSAGE.getMessage();
    }
}
