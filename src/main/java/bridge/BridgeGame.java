package bridge;

import domain.Bridge;
import domain.MoveStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<MoveStatus> result;
    public static final String QUIT = "Q";
    private final Bridge bridge;
    private int gameCount = 1;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.result = new ArrayList<>();
    }

    public void answerReset() {
        result.clear();
    }

    public boolean isWrong() {
        return result.get(getLastIndex()).isMoveStatus();
    }

    private int getLastIndex() {
        return result.size() - 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(int count, String command) {
        result.add(bridge.getStatus(count, command));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if(command.equals(QUIT)){
            return false;
        }
        answerReset();
        return true;
    }

    public void plusGameCount() {
        gameCount++;
    }

    public int getGameCount() {
        return gameCount;
    }

    public List<MoveStatus> getResult() {
        return result;
    }
}
