package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeFlag;
import bridge.domain.UpDownFlag;
import bridge.domain.User;
import bridge.util.BridgeMaker;
import java.util.List;

public class BridgeService {
    private final BridgeMaker bridgeMaker;

    public BridgeService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public Bridge makeBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        return Bridge.of(bridge);
    }

    public BridgeFlag getGameStatus(Bridge bridge, User user) {
        if (bridge.getLength() < user.getMovedLength()) {
            throw new IllegalArgumentException("[ERROR] 유저가 건넌 다리의 길이가 다리의 길이보다 깁니다.");
        }
        return isCrossOver(bridge.getBridge(), user.getMovedPosition());
    }

    private BridgeFlag isCrossOver(List<UpDownFlag> bridge, List<UpDownFlag> user) {
        for (int i = 0; i < user.size(); i++) {
            if (bridge.get(i) != user.get(i)) {
                return BridgeFlag.FAIL;
            }
        }
        if (bridge.size() == user.size()) {
            return BridgeFlag.SUCCESS;
        }
        return BridgeFlag.NOTHING;
    }
}
