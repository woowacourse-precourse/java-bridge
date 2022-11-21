package bridge;

import static bridge.constant.NumberConstant.MAXIMUM_BRIDGE_SIZE;
import static bridge.constant.NumberConstant.MINIMUM_BRIDGE_SIZE;
import static bridge.exception.ExceptionHandler.BRIDGE_SIZE;

import bridge.domain.ArchitecturalDesignOffice;
import bridge.domain.CompareResult;
import bridge.util.BridgeConverter;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateBridgeSize(size);

        List<String> bridgeBlueprint = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            bridgeBlueprint.add(BridgeConverter.covertToBridgeNumber(bridgeNumberGenerator.generate()));
        }

        saveToArchitecturalDesignOffice(bridgeBlueprint);

        return bridgeBlueprint;
    }

    private void validateBridgeSize(final int bridgeSize) {
        if (bridgeSize < MINIMUM_BRIDGE_SIZE.getCode() || bridgeSize > MAXIMUM_BRIDGE_SIZE.getCode()) {
            BRIDGE_SIZE.error();
        }
    }

    public void saveToArchitecturalDesignOffice(final List<String> bridgeBlueprint) {
        ArchitecturalDesignOffice.getInstance()
                                 .save(bridgeBlueprint);
    }

    public CompareResult compareToStoredBridgeBlueprint(final String direction, final int bridgeLocation) {
        return ArchitecturalDesignOffice.getInstance()
                                        .compare(direction, bridgeLocation);
    }

}
