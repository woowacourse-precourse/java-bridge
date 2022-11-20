package bridge;

import static bridge.constant.NumberConstant.MAXIMUM_BRIDGE_SIZE;
import static bridge.constant.NumberConstant.MINIMUM_BRIDGE_SIZE;
import static bridge.exception.ExceptionHandler.BRIDGE_SIZE;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * 제공된 BridgeMaker 클래스를 활용해 구현해야 한다.
 * BridgeMaker의 필드(인스턴스 변수)를 변경할 수 없다.
 * BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
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
