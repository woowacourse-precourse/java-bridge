package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
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
        List<Integer> bridgeNumber = new ArrayList<>();
        List<String> bridgeShape = new ArrayList<>();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            bridgeNumber.add(number);
        }
        for (Integer shape : bridgeNumber) {
            String shapeUD = UpDown.valueOfLabel(shape);
            bridgeShape.add(shapeUD);
        }
        System.out.println(bridgeNumber);
        System.out.println(bridgeShape);
        return bridgeShape;
    }
}
