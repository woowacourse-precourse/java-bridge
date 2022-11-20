package bridge;

import bridge.util.InputConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMaker {

    private static final int DOWN = 0;
    private static final int UP = 1;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    
    public List<String> makeBridge(int size) {
        List<String> bridges = new ArrayList<>();
        makeDirectionToMove(bridges, size);
        return Collections.unmodifiableList(bridges);
    }

    public void makeDirectionToMove(List<String> bridges, int size) {
        for(int i = 0; i < size; i++) {
            changeNumberToDirection(bridges, getRandomNumber());
        }
    }

    public void changeNumberToDirection(List<String> bridges, int number) {
        if(number == DOWN) {
            bridges.add(InputConstant.DOWN.getValue());
        }
        if(number == UP) {
            bridges.add(InputConstant.UP.getValue());
        }
    }
    
    public int getRandomNumber() {
        return bridgeNumberGenerator.generate();
    }
}
