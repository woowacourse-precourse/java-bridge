package bridge.domain;

import bridge.Instances.EndType;

import java.util.ArrayList;
import java.util.List;

import static bridge.Instances.EndType.*;
import static bridge.Instances.Setting.COMMAND_RETRY;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private int trial;
    private int position;
    private String lastMoving;

    public BridgeGame() {
        this.trial = 0;
        this.position = 0;
        this.bridge = new ArrayList<>();
        this.lastMoving = null;
    }

    public BridgeGame(int trial, int position, List<String> bridge, String lastMoving) {
        this.trial = trial;
        this.position = position;
        this.bridge = bridge;
        this.lastMoving = lastMoving;
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
        try {
            bridge = GameUtils.buildBridge();
            //System.out.println(bridge);
            trial = 1;
            position = 0;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void move() {
        getMoving();
        position++;
        boolean correct = isLastMovingCorrect();
        GameUtils.printMoveResult(bridge, position, correct);
    }

    public void moveUntilGameOver() {
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

    private void failEnd(EndType type) {
        if (type.equals(FAIL_RETRY)) {
            trial++;
            position = 0;
        } else if (type.equals(FAIL_QUIT)) {
            printResult(FAIL_QUIT.getSuccess());
        }
    }

    public EndType gameEnded() {
        if (gameSuccess()) {
            return SUCCESS;
        }
        String input = GameUtils.getGameCommand();
        if (input.equals(COMMAND_RETRY)) {
            return FAIL_RETRY;
        }
        return FAIL_QUIT;
    }

    public boolean successEndOrFailEnd(EndType type) {
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
            EndType type = gameEnded();
            replay = successEndOrFailEnd(type);
        } while (replay);
    }
}
