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

    public void move(String input) {
        if (correct(input) == false) {
            gameOver = true;
            drawFalseMap(input);
            return;
        }
        drawTrueMap(input);
        checkEnd();
    }

    public void retry(String input) {
        if (isQuit(input)) {
            gameOver = true;
        } else if (isRetry(input)) {
            gameOver = false;
            cleanUserInput();
            userTry++;
        }
    }

    public List<List<Integer>> map() {
        return List.of(userCorrectUp, userCorrectDown);
    }

    private void checkEnd() {
        if (gameBridge.size() == userCorrectUp.size()) {
            gameOver = true;
            gameCorrect = true;
        }
    }

    BridgeGame(Integer size) {
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        gameBridge = bm.makeBridge(size);
        cleanUserInput();
    }

    private void drawTrueMap(String input) {
        if (isUp(input)) {
            userCorrectUp.add(1);
            userCorrectDown.add(0);
            return;
        }
        userCorrectUp.add(0);
        userCorrectDown.add(1);

    }

    private void drawFalseMap(String input) {
        if (isUp(input)) {
            userCorrectUp.add(-1);
            userCorrectDown.add(0);
            return;
        }
        userCorrectUp.add(0);
        userCorrectDown.add(-1);
    }

    private void cleanUserInput() {
        userCorrectUp = new ArrayList<>();
        userCorrectDown = new ArrayList<>();
    }

    private boolean correct(String input) {
        return input.equals(gameBridge.get(userCorrectUp.size()));
    }

    private boolean isUp(String input) {
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
