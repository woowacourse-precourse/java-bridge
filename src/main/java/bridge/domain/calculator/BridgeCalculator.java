package bridge.domain.calculator;

import bridge.domain.BridgeGame;
import java.util.List;

public class BridgeCalculator {
    private final List<String> crossableBridge;

    public BridgeCalculator(List<String> crossableBridge) {
        this.crossableBridge = crossableBridge;
    }

    /**
     * 사용자 입력값이 해당 라운드에 다리를 건너는 것을 <br/>
     * 성공했는지 실패했는지에 대한 결과를 반환한다.
     * <p>
     *     해당 라운드에 건널 수 있는 값과<br/>
     *     사용자 입력값을 비교한다.
     * </p>
     *
     * @param gameRound index로 사용될 값
     * @param playerInput 비교할 값
     * @return <strong>(boolean)</strong> - 일치한다면 true, 아니면 false 반환
     * @see BridgeGame#startRound()
     */
    public boolean isCrossable(int gameRound, String playerInput) {
        return crossableBridge.get(gameRound).equals(playerInput);
    }
}
