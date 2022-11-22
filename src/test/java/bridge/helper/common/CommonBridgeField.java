package bridge.helper.common;

import bridge.domain.game.Bridge;

public abstract class CommonBridgeField extends CommonStubBridgeGeneratorField {

    protected Bridge bridge = new Bridge(3, stubGenerator);
}
