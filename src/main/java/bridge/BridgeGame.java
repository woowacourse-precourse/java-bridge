package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String BRIDGE_GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_WIN = "성공";
    private static final String GAME_LOSE = "실패";
    private static final InputController inputController = new InputController();
    private static final OutputController outputController = new OutputController();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private int tryCount = 1;
    private int currentPosition = 0;
    private List<Bridge> currentBridge = new ArrayList<>();

    public void start() {
        System.out.println(BRIDGE_GAME_START);
        final int bridgeSize = inputController.inputBridgeSize();
        final List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        gameLoop(bridge, bridgeSize);
    }

    private void gameLoop(List<String> bridge, int bridgeSize) {
        while (currentPosition < bridgeSize) {
            Bridge moveResult = move(bridge, currentPosition);
            currentBridge.add(moveResult);
            outputController.printMap(currentBridge);
            if (isGameOver(moveResult)) {
                return;
            }
            currentPosition++;
        }
        outputController.printResult(currentBridge, GAME_WIN, tryCount);
    }

    private boolean isGameOver(Bridge moveResult) {
        if (moveResult.getUpShape().equals("X") || moveResult.getDownShape().equals("X")) {
            boolean retryResult = retry();
            if (!retryResult) {
                outputController.printResult(currentBridge, GAME_LOSE, tryCount);
                return true;
            }
            gameReset();
        }
        return false;
    }

    private void gameReset() {
        currentBridge = new ArrayList<>();
        currentPosition = 0;
        tryCount++;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Bridge move(List<String> bridge, int currentPosition) {
        String moving = inputController.inputMoving();
        return Calculator.moveCalculate(bridge.get(currentPosition), moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String moving = inputController.inputGameCommand();
        if (moving.equals("R"))
            return true;
        return false;
    }
}