package bridge;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView = new InputView();
    private final BridgeBroker bridgeBroker = new BridgeBroker();
    private final Bridge targetBridge;
    private GameResult gameResult = new GameResult();

    public BridgeGame() {
        OutputView.printWelcome();

        // 다리를 생성한다.
        int bridgeSize = inputView.readBridgeSize();
        targetBridge = bridgeBroker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        Move move = inputView.readMoving();
        gameResult.addBlock(move);
        updateResult();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        GameCommand gameCommand = inputView.readGameCommand();
        if (gameCommand == GameCommand.RESTART) {
            gameResult.retryGame();
            return true;
        }
        return false;
    }

    public static void printGameResult(GameResult gameResult) {
        OutputView.printGame(gameResult);
    }

    public GameResult getResult() {
        return gameResult;
    }

    public void updateResult() {
        List<String> myAnswer = gameResult.getBridge().getBridge();
        List<String> answer = targetBridge.getBridge();

        if (isSameBridge(answer, myAnswer)) {
            gameResult.setProgress(GameProgress.SUCCESS);
        }
        for (int i = 0; i < myAnswer.size(); i++) {
            if (!answer.get(i).equals(myAnswer.get(i))) {
                gameResult.setProgress(GameProgress.FAILURE);
            }
        }
    }

    private boolean isSameBridge(List<String> answer, List<String> myAnswer) {
        if (!isSameSize(answer, myAnswer)) {
            return false;
        }
        for (int i = 0; i < myAnswer.size(); i++) {
            if (!answer.get(i).equals(myAnswer.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isSameSize(List<String> answer, List<String> myAnswer) {
        return answer.size() == myAnswer.size();
    }
}
