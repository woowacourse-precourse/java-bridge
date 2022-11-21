package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final Move[] MOVES_FOR_GENERATED_NUMBERS = new Move[] {Move.DOWN, Move.UP};

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        int count = 0;

        while (count < size) {
            Move move = MOVES_FOR_GENERATED_NUMBERS[this.bridgeNumberGenerator.generate()];
            bridge.add(move.getValue());
            count++;
        }

        return bridge;
    }
}
