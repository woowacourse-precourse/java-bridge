package bridge;

import Model.Moving;
import java.util.List;
import java.util.ArrayList;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public void addNumber(List<String> crossable, int addNumber) {
        if (addNumber == 0) {
            crossable.add(Moving.Down.getMoving());
        } else if (addNumber == 1) {
            crossable.add(Moving.Up.getMoving());
        }
    }

    public List<String> makeBridge(int size) {
        List<String> crossable = new ArrayList<>();
        int addNumber;

        for (int index = 0; index < size; index++) {
            addNumber = bridgeNumberGenerator.generate();
            addNumber(crossable,addNumber);
        }

        return crossable;
    }
}


