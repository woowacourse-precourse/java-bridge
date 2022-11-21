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
    private static final String RESTART_COMMAND = WordCollection.WORD_RESTART.getWord();
    private static final String WORD_FAIL = WordCollection.WORD_FAIL.getWord();
    private static final InputController inputController = new InputController();
    private static final OutputController outputController = new OutputController();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private int tryCount = 1;
    private int currentPosition = 0;
    private String gameResult = GAME_WIN;
    private List<Bridge> movedBridge = new ArrayList<>();


    public void start() {
        System.out.println(BRIDGE_GAME_START);
        final int bridgeSize = inputController.inputBridgeSize();
        final List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        gameLoop(answerBridge, bridgeSize);
    }

    private void gameLoop(List<String> answerBridge, int bridgeSize) {
        while (currentPosition < bridgeSize) {
            boolean isGameOverResult = move(answerBridge);
            if (isGameOverResult) {
                break;
            }
        }
        outputController.printResult(movedBridge, gameResult, tryCount);
    }

    private boolean isMoveFail(Bridge moveResult) {
        return moveResult.getUpShape().equals(WORD_FAIL) || moveResult.getDownShape().equals(WORD_FAIL);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> answerBridge) {
        String moving = inputController.inputMoving();
        Bridge moveResult = Calculator.moveCalculate(answerBridge.get(currentPosition), moving);
        movedBridge.add(moveResult);
        outputController.printMap(movedBridge);
        currentPosition++;
        return isGameOver(moveResult);
    }

    private boolean isGameOver(Bridge moveResult) {
        if (isMoveFail(moveResult)) {
            boolean retryResult = retry();
            if (!retryResult) {
                gameResult = GAME_LOSE;
                return true;
            }
            gameReset();
        }
        return false;
    }

    private void gameReset() {
        movedBridge = new ArrayList<>();
        currentPosition = 0;
        tryCount++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String moving = inputController.inputGameCommand();
        return moving.equals(RESTART_COMMAND);
    }
}