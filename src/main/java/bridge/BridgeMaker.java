package bridge;

import bridge.validation.BridgeMakerValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int RANDOM_NUM_LOWER = 0;
    private static final int RANDOM_NUM_UPPER = 1;
    private static final String LOWER_BOX = "D";
    private static final String UPPER_BOX = "U";

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private List<String> bridge;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        bridge = new ArrayList<>();

        for (int repeatCnt = 0; repeatCnt < size; repeatCnt++) {
            generateNumAndAddBoxToBridge();
        }

        return bridge;
    }

    private void generateNumAndAddBoxToBridge() {
        BridgeMakerValidation bridgeMakerValidation = new BridgeMakerValidation();

        int generatedNum = bridgeNumberGenerator.generate();
        bridgeMakerValidation.validateGeneratedNumValue(generatedNum);

        if (generatedNum == RANDOM_NUM_LOWER) bridge.add(LOWER_BOX);
        if (generatedNum == RANDOM_NUM_UPPER) bridge.add(UPPER_BOX);
        bridgeMakerValidation.validateCorrespondingBoxAddedToBridge(generatedNum, bridge);
    }
}
