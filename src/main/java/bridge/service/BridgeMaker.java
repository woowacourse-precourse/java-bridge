package bridge.service;

import bridge.domain.ErrorMessageConstant;
import bridge.util.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * 클래스 제한 사항: 인스턴스 변수(필드) 변경 불가, 인자, 이름, 반환타입 변경 불가
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
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            String path = designatePath(randomNumber);
            bridge.add(path);
        }
        return bridge;
    }

    private String designatePath(int randomNumber) {
        if (randomNumber == 0) {
            return "D";
        }
        if(randomNumber == 1) {
            return "U";
        }
        throw new IllegalArgumentException(ErrorMessageConstant.RANDOM_NUMBER_GENERATOR_OPERATION_FAILED);
    }
}
