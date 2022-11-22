package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {

    }

    private static List<String> makeBridge(int bridgeSize){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        return bridgeMaker.makeBridge(bridgeSize);
    }

}
