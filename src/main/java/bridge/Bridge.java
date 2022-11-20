package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private int length;
    private List<String> spaces;

    public Bridge(int length) {
        this.length=length;
        setSpaces(length);
    }

    public void setSpaces(int length){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.spaces = bridgeMaker.makeBridge(length);
    }

}
