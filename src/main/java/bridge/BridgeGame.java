package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int nowOn = 0;
    private boolean gameOver = false;
    private boolean win = false;
    private ArrayList<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = new ArrayList<>(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveCode) {
        if (gameOver) return;
        boolean isWrong = judge(moveCode);
        if (!isWrong) {
            nowOn++;
        }
        gameOver = isWrong;
    }


    public boolean judge(String input) {
        if (bridge.get(nowOn).equals(input)) {
            return false;
        }
        return true;
    }

    public void gameOverChecker(int nowOn) {
        if (bridge.size() <= nowOn) {
            gameOver = true;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String reGame) {
        if (reGame.equals(BridgeJoyStick.R.toString())) {
            win = false;
            gameOver = false;
            nowOn = 0;
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isWin() {
        if (bridge.size() == nowOn)
            win = true;
        return win;
    }

    public ArrayList<String> getBridge() {
        return bridge;
    }

    public int getNowOn() {
        return nowOn;
    }

}
