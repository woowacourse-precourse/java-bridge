package bridge;

import bridge.Model.BridgeBlock;

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
        List<Integer> bridgeNumbers = generateBridgeNumbers(size);
        List<String> bridge = bridgeNumbers.stream()
                .map(bridgeNumber -> BridgeBlock.getBlockIdentifier((bridgeNumber)))
                .collect(Collectors.toList());

        return Collections.unmodifiableList(bridge);
    }

    private List<Integer> generateBridgeNumbers(int size) {
        List<Integer> bridgeNumbers = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            int blockNumber = bridgeNumberGenerator.generate();
            bridgeNumbers.add(blockNumber);
        }

        return bridgeNumbers;
    }
}
