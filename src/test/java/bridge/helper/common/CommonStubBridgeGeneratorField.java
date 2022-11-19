package bridge.helper.common;

import bridge.BridgeNumberGenerator;
import bridge.helper.stub.StubBridgeNumberGenerator;
import java.util.List;

public abstract class CommonStubBridgeGeneratorField {

    protected BridgeNumberGenerator stubGenerator = new StubBridgeNumberGenerator(List.of(0, 0, 0));
}
