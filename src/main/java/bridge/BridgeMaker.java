package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> list = new ArrayList<>();
        int[] accessibleSpots = getAccessibleSpots(size);

        for (int i = 0; i < size; i++) {
            list.add(getDirection(accessibleSpots[i]));
        }

        return list;
    }

    public int[] getAccessibleSpots(int size) {
        int[] accessibleSpots = new int[size];
        for (int i = 0; i < size; i++) {
            accessibleSpots[i] = bridgeNumberGenerator.generate();
        }
        return accessibleSpots;
    }

    private String getDirection(int number) {
        if (number == RANDOM_LOWER_INCLUSIVE) {
            return "D";
        }
        return "U";
    }

}
