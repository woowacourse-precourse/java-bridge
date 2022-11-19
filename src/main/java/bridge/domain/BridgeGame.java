package bridge.domain;

import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.PlayerMap;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMap bridgeMap;
    private String status;
    private int count;

    public BridgeGame(BridgeMap bridgeMap) {
        this.bridgeMap = bridgeMap;
        this.status = "성공";
        this.count = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public PlayerMap move(String place, PlayerMap playerMap) {
        playerMap.addResult(place,
                bridgeMap.checkMapWithIndex(playerMap.getSize(), place));
        return playerMap;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public PlayerMap retry(String command, PlayerMap playerMap) {
        if (command.equals("Q")) {
            status = "실패";
            return playerMap;
        }
        count++;
        return new PlayerMap();
    }

    public int getCount() {
        return count;
    }

    public String getStatus() {
        return status;
    }

    public boolean isInputRetry() {
        return status.equals("실패");
    }

    public int getBridgeMapSize() {
        return bridgeMap.getSize();
    }
}
