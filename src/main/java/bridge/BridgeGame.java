package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> gameBridge;
    List<Integer> userCorrectUp;
    List<Integer> userCorrectDown;
    private Integer userTry = 1;
    Boolean gameCorrect = false;
    Boolean gameOver = false;

    public void move() {
    }

    public void retry() {
    }

    BridgeGame(Integer size) {
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        gameBridge = bm.makeBridge(size);
        cleanUserInput();
    }

    private void cleanUserInput() {
        userCorrectUp = new ArrayList<>();
        userCorrectDown = new ArrayList<>();
    }
    private boolean isUp(String input){
        return input.equals("U");
    }

    private boolean isQuit(String input) {
        return (input.equals("q") || input.equals("Q"));
    }

    private boolean isRetry(String input) {
        return (input.equals("r") || input.equals("R"));
    }

    public int userTry() {
        return userTry;
    }

    public boolean isCorrect() {
        return gameCorrect;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
