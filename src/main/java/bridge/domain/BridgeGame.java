package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGame {
    private static final StringBuilder SUCCESS_MOVE_MARK = new StringBuilder(" O ");
    private static final StringBuilder FAIL_MOVE_MARK = new StringBuilder(" X ");
    private final List<String> bridgeGame;
    private int tryCount;

    public BridgeGame(List<String> bridgeGame, int tryCount) {
        this.bridgeGame = bridgeGame;
        this.tryCount = tryCount;
    }

    public int size() {
        return bridgeGame.size();
    }

    public String toString(List<String> result) {
        return result.toString();
    }

    public boolean move(String moveSide, int index) {
        return bridgeGame.get(index).equals(moveSide);
    }

    public StringBuilder createMoveMark(String moveWord, int index) {
        if (move(moveWord, index)) {
            return SUCCESS_MOVE_MARK;
        }
        return FAIL_MOVE_MARK;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void retryCount() {
        tryCount ++;
    }

    public boolean retry() {
        OutputView.printRetryMessage();
        String command = InputView.inputGameCommand();
        if (command.equals("R")){
            return true;
        }
        if (command.equals("Q")){
            return false;
        }
        throw new IllegalArgumentException("[ERROR] 'R' 또는 'Q'를 입력해 주세요.");
    }
}
