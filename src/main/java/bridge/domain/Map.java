package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final List<BridgeFlag> upper;
    private final List<BridgeFlag> lower;

    public Map() {
        upper = new ArrayList<>();
        lower = new ArrayList<>();
    }

    public BridgeFlag cross(Bridge bridge, User user) {
        int userIndex = user.getCurrentIndex();
        UpDownFlag bridgeUpDown = bridge.getIndexOf(userIndex);
        UpDownFlag userUpDown = user.getCurrentUpDown();
        if (bridgeUpDown == userUpDown) {
            return crossSuccess(userUpDown);
        }
        return crossFail(userUpDown);
    }

    private BridgeFlag crossFail(UpDownFlag userUpDown) {
        if (userUpDown == UpDownFlag.UP) {
            crossUpperFail();
        }
        if (userUpDown == UpDownFlag.DOWN) {
            crossLowerFail();
        }
        return BridgeFlag.FAIL;
    }

    private BridgeFlag crossSuccess(UpDownFlag userUpDown) {
        if (userUpDown == UpDownFlag.UP) {
            crossUpperSuccess();
        }
        if (userUpDown == UpDownFlag.DOWN) {
            crossLowerSuccess();
        }
        return BridgeFlag.SUCCESS;
    }

    private void crossUpperSuccess() {
        upper.add(BridgeFlag.SUCCESS);
        lower.add(BridgeFlag.NOTHING);
    }

    private void crossLowerSuccess() {
        upper.add(BridgeFlag.NOTHING);
        lower.add(BridgeFlag.SUCCESS);
    }

    private void crossUpperFail() {
        upper.add(BridgeFlag.FAIL);
        lower.add(BridgeFlag.NOTHING);
    }

    private void crossLowerFail() {
        upper.add(BridgeFlag.NOTHING);
        lower.add(BridgeFlag.FAIL);
    }

    public List<BridgeFlag> getUpper() {
        return List.copyOf(upper);
    }

    public List<BridgeFlag> getLower() {
        return List.copyOf(lower);
    }
}
