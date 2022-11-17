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

    public void update(Bridge bridge, User user) {
        if (user.getMovedLength() > bridge.getLength()) {
            throw new IllegalArgumentException("[ERROR] 유저가 건넌 다리의 길이가 다리의 길이보다 깁니다.");
        }
        upper.clear();
        lower.clear();
        List<UpDownFlag> userUpDowns = user.getMovedPosition();
        List<UpDownFlag> bridgeUpDowns = bridge.getBridge();
        draw(userUpDowns, bridgeUpDowns);
    }

    private void draw(List<UpDownFlag> userUpDowns, List<UpDownFlag> bridgeUpDowns) {
        for (int i = 0; i < userUpDowns.size(); i++) {
            UpDownFlag bridgeUpdown = bridgeUpDowns.get(i);
            UpDownFlag userUpDown = userUpDowns.get(i);
            if (bridgeUpdown == userUpDown) {
                crossSuccess(userUpDown);
            }
            if (bridgeUpdown != userUpDown) {
                crossFail(userUpDown);
            }
        }
    }

    private void crossFail(UpDownFlag userUpDown) {
        if (userUpDown == UpDownFlag.UP) {
            crossUpperFail();
        }
        if (userUpDown == UpDownFlag.DOWN) {
            crossLowerFail();
        }
    }

    private void crossSuccess(UpDownFlag userUpDown) {
        if (userUpDown == UpDownFlag.UP) {
            crossUpperSuccess();
        }
        if (userUpDown == UpDownFlag.DOWN) {
            crossLowerSuccess();
        }
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
