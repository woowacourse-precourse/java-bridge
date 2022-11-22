package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int retryCount;
    private List<Boolean> gameState;
    private Bridge bridge;
    private User user;
    private int bridgeSize;

    private boolean restart;

    public BridgeGame() {
        retryCount = 1;
        restart = true;
    }

    private void gameReset() {
        gameState.clear();
        user.getUserLocation().clear();
    }

    public void gameStart() {
        OutputView.printStartMessage();
    }

    public void setBridgeSize() {
        OutputView.printInputBridgeSizeMessage();
        bridgeSize = InputView.readBridgeSize();

        bridge = new Bridge(bridgeSize);
        user = new User(bridgeSize);

        gameState = new ArrayList<>(bridgeSize);
    }


    public boolean move(String direction) {
        user.move(direction);
        return (bridge.getBrideState().get(user.getUserLocation().size() - 1).equals(direction));
    }

    public void playRound() {
        while (restart) {
            OutputView.printInputMovingMessage();
            restart = move(InputView.readMoving());
            OutputView.printMap(user.getUserLocation(), restart);
            checkAnswer();
        }
    }


    public boolean compareBridgeLength() {
        return bridge.getBrideSize() == user.getUserLocation().size();
    }

    public void checkAnswer() {
        if (restart && compareBridgeLength()) {
            EndGame();
            restart = false;
            return;
        }
        if (!restart) {
            OutputView.printInputGameCommandMessage();
            wrongAnswerPlayAgain();
        }
    }

    public void wrongAnswerPlayAgain() {
        String gameCommand = InputView.readGameCommand();
        if (gameCommand.equals("R")) {
            retry(bridgeSize);
            retryCount += 1;
            restart = true;
            return;
        }
        EndGame();
    }

    public void EndGame() {
        OutputView.printResult(user.getUserLocation(), restart, retryCount);
    }

    public void retry(int bridgeSize){
        user = new User(bridgeSize);
    }
}