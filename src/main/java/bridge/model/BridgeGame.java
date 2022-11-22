package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.config.BridgeComponent;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private static final int INIT_LOCATION = -1;
    private static final int INIT_TRIAL = 1;

    private final Bridge bridge;

    private final List<MoveRecord> records;
    private int trial;
    private int currentLocation;

    public BridgeGame(int bridgeSize, BridgeNumberGenerator bridgeNumberGenerator) {
        currentLocation = INIT_LOCATION;
        trial = INIT_TRIAL;
        records = new ArrayList<>();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public boolean move(String step) {
        stepValidate(step);
        currentLocation += 1;

        boolean success = bridge.checkStep(currentLocation, step);
        records.add(MoveRecord.addRecord(step, success));

        return success;
    }

    private void stepValidate(String step) {
        if (!BridgeComponent.findBySymbol(step)) {
            throw new IllegalArgumentException("U또는 D만 입력할 수 있습니다.");
        }
    }

    public boolean isOver() {
        return bridge.isEnd(currentLocation);
    }

    public boolean checkFinalStep() {
        return records.get(currentLocation).isSuccess();
    }

    public List<MoveRecord> getResult() {
        return records;
    }

    public void retry() {
        currentLocation = INIT_LOCATION;
        trial += 1;
        records.clear();
    }

    public int getTrial() {
        return trial;
    }
}
