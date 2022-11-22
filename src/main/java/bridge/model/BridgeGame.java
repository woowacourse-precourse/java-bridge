package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

/**
 * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final BridgeMaker bridgeMaker;
    private final Bridge bridge;

    private int currentLocation;
    private int trial;

    public BridgeGame(int size) {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public boolean start(String step) {
        return bridge.checkStep(currentLocation, step);
    }

    public boolean move(String step) {
        currentLocation += 1;
        return bridge.checkStep(currentLocation, step);
    }

    public boolean isOver() {
        return bridge.getSize() == currentLocation;
    }

    public List<MoveRecord> getResult() {
        return records;
    }

    public void retry() {
        trial = 0;
    }


}
