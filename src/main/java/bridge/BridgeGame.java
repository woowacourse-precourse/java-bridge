package bridge;

import bridge.enums.ControlKey;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    /**
     * 필드(인스턴스 변수)추가 가능
     * 인자와 반환타입은 추가, 변경 가능
     * 메서드 추가, 변경 가능
     * <p>
     * 메서드 이름 변경 불가능
     */

    private Bridge bridge;
    private MapMaker mapMaker;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.mapMaker = new MapMaker();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String inputKey, int index) {
        return bridge.canCross(inputKey, index);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String inputKey) {
        return inputKey.equals(ControlKey.RETRY.getKey());
    }

    public String getMap(int index, String move) {
        return mapMaker.makeMap(bridge, index, move);
    }

    public String getResultMap() {
        return mapMaker.makeResultMap();
    }

    public void initMap() {
        mapMaker.initBridge();
    }
}
