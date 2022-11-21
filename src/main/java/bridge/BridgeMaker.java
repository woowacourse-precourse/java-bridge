package bridge;

import bridge.util.InputConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class BridgeMaker {

    private static final int DOWN = 0;
    private static final int UP = 1;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    
    public List<String> makeBridge(int size) {
        List<String> bridges = new ArrayList<>();
        makeDirectionToMovePossible(bridges, size);
        return Collections.unmodifiableList(bridges);
    }

    public void makeDirectionToMovePossible(List<String> bridges, int size) {
        IntStream.range(0, size).forEach( e -> changeNumberToDirection(bridges, makeRandomNumber()));
    }

    public void changeNumberToDirection(List<String> bridges, int number) {
        if(number == DOWN) {
            bridges.add(InputConstant.DOWN.getValue());
        }
        if(number == UP) {
            bridges.add(InputConstant.UP.getValue());
        }
    }
    
    public int makeRandomNumber() {
        return bridgeNumberGenerator.generate();
    }
}
