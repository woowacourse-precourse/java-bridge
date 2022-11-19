package bridge.helper.common;

import bridge.BridgeNumberGenerator;
import bridge.domain.game.Bridge;
import bridge.helper.stub.StubBridgeNumberGenerator;
import java.util.List;

public abstract class CommonBridgeField {

    private BridgeNumberGenerator generator = new StubBridgeNumberGenerator(List.of(0, 0, 0));
    protected Bridge bridge = new Bridge(3, generator);
}
