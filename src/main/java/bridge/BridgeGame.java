package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final String PASS = "O";
    private final String FAIL = "X";
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final List<String> bridge;
    private final int bridgeSize;
    private int currentRound;
    public List<List<String>> gameProgress;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeSize = inputView.readBridgeSize();
        this.currentRound = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String selectedBridge) {
        List<String> result = checkAnswer(selectedBridge);
        gameProgress.add(result);
        if (result.get(1).equals(PASS)) {
            currentRound++;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public List<String> checkAnswer(String selectedBridge) {
        String answer = bridge.get(currentRound - 1);
        if (answer.equals(selectedBridge)) {
            return List.of(selectedBridge, PASS);
        }
        return List.of(selectedBridge, FAIL);
    }
}
