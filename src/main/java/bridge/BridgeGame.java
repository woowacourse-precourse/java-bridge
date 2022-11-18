package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private ArrayList<String> bridge;
    private int nowOn=0;

    private boolean gameOver = false;

    public BridgeGame(List<String> bridge)
    {
        this.bridge=new ArrayList<>(bridge);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveCode) {
        gameOverChecker(nowOn);
        if(gameOver) return;
        if(moveCode.equals(BridgeJoyStick.U.toString()))
        {

        }
        if(moveCode.equals(BridgeJoyStick.D.toString()))
        {

        }
    }

    public void gameOverChecker(int nowOn)
    {
        if(bridge.size()<=nowOn)
        {
            gameOver = true;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public boolean isGameOver() {
        return gameOver;
    }

}
