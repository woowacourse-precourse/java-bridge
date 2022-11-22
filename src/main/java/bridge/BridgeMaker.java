package bridge;
import java.util.ArrayList;
import java.util.List;
public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        BridgeCharacterGenerator bridgeCharacterGenerator = new BridgeCharacterGenerator();
        for (int index = 0; index < size; index++) {
            bridge.add(bridgeCharacterGenerator.generate(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }
}
