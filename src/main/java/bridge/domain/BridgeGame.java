package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.BridgeGame.endType.FAIL_QUIT;
import static bridge.domain.BridgeGame.endType.SUCCESS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public enum endType {
        SUCCESS(false, true), FAIL_RETRY(true, false), FAIL_QUIT(false, false);
         final boolean retry;
         final boolean success;

        endType(boolean retry, boolean success) {
            this.retry = retry;
            this.success = success;
        }

        public boolean getRetry() {
            return this.retry;
        }

        public boolean getSuccess() {
            return this.success;
        }
    }

    List<String> bridge;
    int trial;
    int position;
    String lastMoving;

    public BridgeGame() {
        this.trial = 0;
        this.position = 0;
        this.bridge = new ArrayList<>();
        this.lastMoving = null;
    }

    private void getMoving() {
        lastMoving = GameUtils.getMoving();
    }

    public boolean isLastMovingCorrect() {
        return bridge.get(position - 1).equals(lastMoving);
    }

    public boolean gameSuccess() {
        return ((position == bridge.size()) && isLastMovingCorrect());
    }

    public void start() {
        bridge = GameUtils.buildBridge();
        //System.out.println(bridge);
        trial = 1;
        position = 0;
    }

    public void move() {
        getMoving();
        position++;
        boolean correct = isLastMovingCorrect();
        GameUtils.printMoveResult(bridge, position, correct);
    }

    private void moveUntilGameOver() {
        do {
            move();
        } while (isLastMovingCorrect() && !gameSuccess());
    }

    public void printResult(boolean success) {
        GameUtils.printGameResult(bridge, position, success);
        GameUtils.printSuccessResult(success, trial);
    }

    private void successEnd() {
        printResult(SUCCESS.getSuccess());
    }

    private void failEnd(endType type) {
        if (type.equals(endType.FAIL_RETRY)) {
            trial++;
            position = 0;
        } else if (type.equals(endType.FAIL_QUIT)) {
            printResult(FAIL_QUIT.getSuccess());
        }
    }

    private endType gameEnded() {
        if (gameSuccess()) {
            return SUCCESS;
        }
        String input = GameUtils.getGameCommand();
        if (input.equals("R")) {
            return endType.FAIL_RETRY;
        }
        return endType.FAIL_QUIT;
    }

    private boolean successEndOrFailEnd(endType type) {
        if (type.equals(SUCCESS)) {
            successEnd();
            return type.getRetry();
        }
        failEnd(type);
        return type.getRetry();
    }

    public void playGame() {
        start();
        boolean replay;
        do {
            moveUntilGameOver();
            endType type = gameEnded();
            replay = successEndOrFailEnd(type);
        } while (replay);
    }
}
