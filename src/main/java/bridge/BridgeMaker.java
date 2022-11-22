package bridge;

import bridge.value.BridgeCharacter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return  new ArrayList<>(Collections.nCopies(size, null)).stream().map((elem) -> BridgeCharacter.makeBridgeCharacter(
                bridgeNumberGenerator.generate()).getCharacter()).collect(Collectors.toList());
    }
}
