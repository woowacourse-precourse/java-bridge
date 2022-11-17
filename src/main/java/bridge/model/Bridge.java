package bridge.model;

import bridge.BridgeRandomNumberGenerator;

public class Bridge {
    private int number;

    public int execute() {
        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        return numberGenerator.generate();
    }

    public void setBridgeValue(int number) {
        this.number = number;
    }
}
