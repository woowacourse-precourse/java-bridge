package bridge.service;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        ArrayList<String> bridgeLoad = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            bridgeLoad.add(bringRandomNumber());
        }

        return bridgeLoad;
    }

    private String bringRandomNumber() {
        int randomNumber = bridgeNumberGenerator.generate();
        String bringNumber = "";
        if (randomNumber == 1) {
            bringNumber = "U";
        } else if (randomNumber == 0) {
            bringNumber = "D";
        }
        return bringNumber;
    }
}
