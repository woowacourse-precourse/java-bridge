package bridge;

import bridge.Setting.OutputViewPrintEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<Boolean> bridgeCorrect;
    private int tryTime;

    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator, int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeCorrect = new ArrayList<>();
        tryTime = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void move(String readMoving) {
        int nowPosition = bridgeCorrect.size();
        if (nowPosition < bridge.size()) {
            boolean correct = bridge.get(nowPosition).equals(readMoving);
            bridgeCorrect.add(correct);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeCorrect.remove(bridgeCorrect.size() - 1);
        tryTime += 1;
    }

    public String printSuccess(){
        String line = OutputViewPrintEnum.OUTPUT_CHECK_SUCCESS.getMessage();
        if (bridge.size() <= bridgeCorrect.size()) {
            return line.replace(OutputViewPrintEnum.CHANGE_STRING.getMessage()
                    , OutputViewPrintEnum.OUTPUT_RESULT_SUCCESS.getMessage());
        }
        return line.replace(OutputViewPrintEnum.CHANGE_STRING.getMessage()
                , OutputViewPrintEnum.OUTPUT_RESULT_FAIL.getMessage());
    }
    public List<Boolean> getBridgeCorrect() {
        return this.bridgeCorrect;
    }

    public List<String> getBridge() {
        return bridge;
    }
}
