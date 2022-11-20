package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static final String CMD_UP = "U";
    public static final String CMD_DOWN = "D";
    public static final String CMD_RETRY = "R";
    public static final String CMD_QUIT = "Q";

    private Bridge bridge;
    private int tryCount;
    private Player player;

    public BridgeGame() {
        player = new Player();
        bridge = null;
        tryCount = 1;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String command) {
        player.setCommand(command);
        player.setPosition(player.getPosition() + 1);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player = new Player();
        tryCount++;
    }

    public boolean isPlayerAlive() {
        if (player.getPosition() > 0 && !bridge.get(player.getPosition() - 1).equals(player.getCommand())) {
            return false;
        }
        return true;
    }

    public boolean isSuccess() {
        if (bridge.size() == player.getPosition()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (isSuccess()) {
            return "성공";
        }
        return "실패";
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setBridge(Bridge newBridge) {
        bridge = newBridge;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public Player getPlayer() {
        return player;
    }
}
