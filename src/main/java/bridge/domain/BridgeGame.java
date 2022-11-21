package bridge.domain;

import bridge.View.InputView;
import bridge.View.OutputView;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    final InputView inputView;
    final OutputView outputView;
    List<String> bridge;
    int trial;
    int position;
    String lastMoving;
    boolean correct;
    boolean success;
    boolean gameOn;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.trial = 1;
        this.position = 0;
        this.bridge = new ArrayList<>();
        this.lastMoving = null;
        this.correct = false;
        this.success = false;
        this.gameOn = false;
    }

    public void start() {
        int size = inputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
        //System.out.println(bridge);
        position = 0;
        gameOn = true;
    }

    private void getMoving() {
        lastMoving = inputView.readMoving();
    }

    private boolean isCorrectMoving(String moving) {
        return bridge.get(position - 1).equals(moving);
    }

    public boolean isLastMovingCorrect() {
        return isCorrectMoving(lastMoving);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        getMoving();
        position++;
        boolean correct = isLastMovingCorrect();
        outputView.printMap(bridge, position, correct);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String input = inputView.readGameCommand();
        if (input.equals("R")) {
            trial++;
            position = 0;
            return true;
        } else if (input.equals("Q")) {
            endGame(false);
        }
        return false;
    }

    public boolean gameSuccess() {
        return ((position == bridge.size()) && isLastMovingCorrect());
    }

    public void endGame(boolean success) {
        outputView.printResult(bridge, position, success);
        outputView.printSuccessOrFail(success, trial);
    }

    public void playGame() {
        start();
        while (gameOn) {
            do {
                move();
                correct = isLastMovingCorrect();
                success = gameSuccess();
            } while (correct && !success);

            if (success) {
                endGame(true);
                gameOn = false;
            } else {
                gameOn = retry();
            }
        }
    }


}
