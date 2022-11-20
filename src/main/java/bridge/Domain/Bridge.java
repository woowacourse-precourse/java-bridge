package bridge.Domain;

import bridge.BridgeMaker;

import java.util.List;

public class Bridge {
    private final List<String> spaces;
    private final BridgeMaker bridgeMaker;

    public Bridge(BridgeMaker bridgeMaker, int size){
        this.bridgeMaker = bridgeMaker;
        spaces = bridgeMaker.makeBridge(size);
    }
}
