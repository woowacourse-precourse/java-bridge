package bridge;

import bridge.exception.ErrorCode;
import bridge.type.BridgeSpaceStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker implements BridgeMakerInf {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    @Override
    public List<String> makeBridge(int size) {
        validateSize(size);
        return makeSequence(size);
    }

    private List<String> makeSequence(int size) {
        List<String> sequence = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            BridgeSpaceStatus status = BridgeSpaceStatus.findByNumber(randomNumber);
            sequence.add(status.getLetter());
        }
        return sequence;
    }

    private void validateSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_SIZE.getMessage());
        }
    }
}
