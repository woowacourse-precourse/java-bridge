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

    /**
     * 다리 건너기 게임을 실행하는 메서드
     */
    public void run() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();

        newBridge = createBridge(bridgeSize);
        List<String> playerInput = new ArrayList<>();

        trial(playerInput);

    }

    /**
     * 한 번 이동할 때마다 실행되는 전체 메서드
     *
     * @param playerInput
     */
    private void trial(List<String> playerInput) {
        int score = 0;
        for (int i = 0; i < newBridge.size(); i++) {
            playerInput = updatePlayerInput(playerInput, move());
            score = calculateScore(playerInput);
            if (score == newBridge.size()) {
                outputView.printResult("성공", gameTrialCount);
                return;
            }
            if (score != playerInput.size()) {
                break;
            }
        }
        retry();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move() {
        outputView.printMove();
        return inputView.readMoving();
    }

    /**
     * 사용자가 한 칸 이동한 경우 기록을 업데이트 해주는 메서드
     * @param playerInput
     * @param move
     * @return
     */
    public List<String> updatePlayerInput(List<String> playerInput, String move) {
        playerInput.add(move);
        return playerInput;
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
