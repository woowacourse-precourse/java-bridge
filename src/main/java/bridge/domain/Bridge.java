package bridge.domain;

import java.util.List;

import static bridge.utils.Constants.*;

public class Bridge {
    private int bridgeSize;
    private List<String> bridgeBlocks;

    public Bridge(int inputSize){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeSize = inputSize;
        bridgeBlocks = bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean isUpBlock(int blockNumber){
        if(bridgeBlocks.get(blockNumber) == DOWN_BLOCK)
            return true;
        return false;
    }
}
