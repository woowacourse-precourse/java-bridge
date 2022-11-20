package bridge.domain;

import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.Moving;
import bridge.domain.vo.PlayerMap;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMap bridgeMap;
    private PlayerMap playerMap;
    boolean isMove;
    private int count;

    public BridgeGame(BridgeMap bridgeMap) {
        this.bridgeMap = bridgeMap;
        this.isMove = true;
        this.playerMap = new PlayerMap();
        this.count = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public PlayerMap move(Moving moving) {
        isMove = bridgeMap.isEqualWithIndex(playerMap.getSize(), moving);
        playerMap.addResult(moving, isMove);
        return playerMap;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public PlayerMap retry(String command) {
        if (command.equals("R")) {
            playerMap = new PlayerMap();
            isMove = true;
            count++;
            return playerMap;
        }
        return playerMap;
    }

    public int getCount() {
        return count;
    }

    public String getStatus() {
        if (isMove) {
            return "성공";
        }
        return "실패";
    }

    public boolean isMove() {
        return isMove;
    }

    public boolean isEnd() {
        return !isMove || getBridgeMapSize() == playerMap.getSize();
    }

    private int getBridgeMapSize() {
        return bridgeMap.getSize();
    }
}
