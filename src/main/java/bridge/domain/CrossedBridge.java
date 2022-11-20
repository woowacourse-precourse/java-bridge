package bridge.domain;

import bridge.domain.bridgeenum.MapStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrossedBridge {
    private List<String> crossedBridge;

    public CrossedBridge() {
        crossedBridge = new ArrayList<>();
    }

    public void updateMoveResult(Boolean success) {
        crossedBridge.add(MapStatus.findMarkByValue(success));
    }

    public List<String> getCrossedBridge() {
        return Collections.unmodifiableList(crossedBridge); //이거 의미있는건지 확인
    }

    public void initialize() {
        this.crossedBridge.clear();
    }

}
