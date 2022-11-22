package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final List<String> bridge;
    private UserBridge userBridge;
    private int tryCount;


    public BridgeGame(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        outputView.startGame();
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        this.tryCount = 0;
    }

    public void playGame() {
        this.userBridge = new UserBridge();
        tryCount++;
        for (int step = 1; step <= bridge.size(); step++)
            if (!move(step)) {
                retry();
                return;
            }
        outputView.printResult(userBridge, "성공", tryCount);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean move(int step) {
        String moving = inputView.readMoving();
        boolean result = bridge.get(step - 1).equals(moving);
        userBridge.markUpResult(moving, result);
        outputView.printMap(userBridge);
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("Q")) {
            outputView.printResult(userBridge, "실패", tryCount);
            return;
        }
        playGame();
    }
}
