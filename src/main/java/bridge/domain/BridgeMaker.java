package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class BridgeMaker {
    private final int minLength = 3;
    private final int maxLength = 20;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public final static List<String> UP_DOWN_SELECTOR = List.of("U", "D");

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeRandomBridgeProcess(int size){
        validationBridge(size);
        return makeBridge(size);
    }
    private void validationBridge(int size){
        if(size < minLength || size > maxLength){
            throw new IllegalArgumentException(Errors.BRIDGE_LENGTH.getMessage());
        }
    }

    public List<String> makeBridge(int size) {
        return  IntStream.range(0, size)
                .map(n -> bridgeNumberGenerator.generate())
                .mapToObj(UP_DOWN_SELECTOR::get)
                .collect(toList());
    }
}
