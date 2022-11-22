package bridge.Service;

import bridge.BridgeRandomNumberGenerator;
import bridge.View.ValidateSet;

import java.util.ArrayList;
import java.util.List;

public class GenerateComBridge {

    ValidateSet validateSet = new ValidateSet();

    public List<Integer> generate(int size) {
        List<Integer> comBridge = new ArrayList<>();
        for (int i=0;i<size;i++) {
            comBridge.add(getRandom());
        }
        return comBridge;
    }

    public int getRandom() {
        int num;
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        while (!IsValidate(num = bridgeRandomNumberGenerator.generate())) {
            return num;
        }
        return num;
    }

    public boolean IsValidate(int random) {
        try {
            validateSet.Computer(random);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
