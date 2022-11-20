package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int tryNumber;
    private User user = new User();
    private List<String> bridge;
    private boolean successOrFail;

    public void run() {
        startGame();
        makeBridge();
        move();
        endGame();
    }

    private void startGame() {
        tryNumber = 1;
        successOrFail = false;
        ViewMessage.printGameStartMessage();
        user.resetUserMoving();
    }

    private void makeBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        ViewMessage.printBridgeSizeInputRequest();

        int bridgeSize = InputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        boolean continueGame = true;

        keepMoving(continueGame, user.getUserMovingRecord());

        if (!successOrFail) {
            retry();
        }
    }

    private void keepMoving(boolean continueGame, List<String> userMoving) {
        while (continueGame) {
            if (completeCrossBridge(userMoving)) {
                successOrFail = true;
                break;
            }
            continueGame = moveOnce();
        }
    }

    private boolean completeCrossBridge(List<String> userMoving) {
        if (userMoving.size() == bridge.size()) {
            return true;
        }

        return false;
    }

    private boolean moveOnce() {
        ViewMessage.printMovingInputRequest();

        String moving = InputView.readMoving();
        List<String> userMoving = user.recordUserMoving(moving);
        return OutputView.printMap(userMoving, bridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry() {
        ViewMessage.printGameCommandInputRequest();
        String gameCommand = InputView.readGameCommand();

        if (gameCommand.equals("R")) {
            user.resetUserMoving();
            tryNumber++;
            move();
        }
        if (gameCommand.equals("Q")) {
            successOrFail = false;
        }
    }

    public void endGame() {
        if (successOrFail) {
            printGameResult();
        }
        if (!successOrFail) {
            printGameResult();
        }
    }

    private void printGameResult() {
        ViewMessage.printEndGameMessage();
        OutputView.printMap(user.getUserMovingRecord(), bridge);
        OutputView.printResult(tryNumber, successOrFail);
    }
}
