package bridge.model;

import bridge.BridgeRandomNumberGenerator;
import bridge.config.BridgeComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {

    private static final int INIT_LOCATION = -1;
    private static final int INIT_TRIAL = 1;

    private final Bridge bridge;
    private final BridgeMaker bridgeMaker;

    private final List<MoveRecord> records;
    private int trial;
    private int currentLocation;

    public BridgeGame(int bridgeSize) {
        currentLocation = INIT_LOCATION;
        trial = INIT_TRIAL;
        records = new ArrayList<>();

        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void move(String step) {
        stepValidate(step);
        currentLocation += 1;
        boolean success = bridge.checkStep(currentLocation, step);
        records.add(MoveRecord.addRecord(step, success));
    }

    private void stepValidate(String step) {
        if (!BridgeComponent.findBySymbol(step)) {
            throw new IllegalArgumentException("U또는 D만 입력할 수 있습니다.");
        }
    }

    public boolean isOver() {
        return bridge.getSize() == currentLocation;
    }

    public List<MoveRecord> getResult() {
        return records;
    }

    public void retry() {
        currentLocation = INIT_LOCATION;
        trial += 1;
    }
}
