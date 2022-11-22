package bridge;

import ui.InputView;
import ui.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final OutputView outputView;
    private final InputView inputView;
    private List<String> newBridge;
    private int gameTrialCount = 1;

    public BridgeGame(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void move() {
    }

    public void retry() {
    }


    /**
     * 다리 길이를 입력받아 다리를 생성하는 메서드
     *
     * @param bridgeSize
     * @return
     */
    public List<String> createBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 입력할 때마다 점수를 계산해주는 메서드
     *
     * @param playerInput
     * @return
     */
    public int calculateScore(List<String> playerInput) {
        int score = 0;
        for (int i = 0; i < playerInput.size(); i++) {
            if (playerInput.get(i).equals(newBridge.get(i))) {
                score += 1;
            }
        }
        return score;
    }

    /**
     * 테스트용으로 사용하는 메서드
     * @param bridge
     */
    public void setNewBridge(List<String> bridge) {
        newBridge = bridge;
    }
}
