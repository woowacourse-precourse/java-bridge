package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> makeBridgeResult, int makeBridgeResultIndex, String userMoveInput) {
        List<String> bridgeResult = makeBridgeResult.subList(0, makeBridgeResultIndex+1);

        for (int index = 0 ; index <= makeBridgeResultIndex ; index++) {

        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    /**
     * 유저에게 받은 값과 생성된 다리의 index값을 비교하여 upperBridge와 lowerBridge에 값 추가
     * 만들어진 문자열을 바탕으로 출력할 예정
     */

}
