package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

public class Computer {

    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    public int createRandomNumber() {
        return bridgeRandomNumberGenerator.generate();
    }

}
