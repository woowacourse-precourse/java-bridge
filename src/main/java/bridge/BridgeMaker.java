package bridge;

import bridge.identifiers.Direction;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    public static final int BRIDGE_MAX_LENGTH = 20;
    public static final int BRIDGE_MIN_LENGTH = 3;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validate(size);
        List<String> securePath = new ArrayList<>(size);
        while(size-- != 0) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            Direction direction = Direction.parseDirection(bridgeNumber);
            securePath.add(direction.getAsString());
        }
        return securePath;
    }

    private void validate(int size){
        if(size < BRIDGE_MIN_LENGTH || BRIDGE_MAX_LENGTH < size)
            throw new IllegalArgumentException(
                    "다리의 길이는 3이상 20이하의 값이어야 합니다."
            );
    }
}
