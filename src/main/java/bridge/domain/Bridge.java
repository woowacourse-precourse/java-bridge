package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    int size;
    List<String> bridge;
    List<String> userRoute;

    public Bridge(int size) {
        BridgeNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        this.size = size;
        this.bridge = bridgeMaker.makeBridge(this.size);
        this.userRoute = new ArrayList<>();
    }

    public void updateUserRoute(String direction) {
        userRoute.add(direction);
    }
}
