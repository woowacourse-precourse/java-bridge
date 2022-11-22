package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private static final int RANDOM_LOWER_INCLUSIVE = 0;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * 주어진 길이의 다리를 만든다.
     *
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        int[] accessibleSpots = getAccessibleSpots(size);

        for (int i = 0; i < size; i++) {
            bridge.add(getDirection(accessibleSpots[i]));
        }
        return bridge;
    }

    /**
     * 주어진 길이의 다리를 만든다. 테스트 용으로 오버로딩하였다.
     *
     * @param accessibleSpots 각 칸마다 건널 수 있는 위치 배열. 0과 1로 구성되어 있다.
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int[] accessibleSpots) {
        List<String> bridge = new ArrayList<>();
        for (int accessibleSpot : accessibleSpots) {
            bridge.add(getDirection(accessibleSpot));
        }
        return bridge;
    }

    /**
     * 각 칸마다 건널 수 있는 위치를 알려준다.
     *
     * @param size 다리의 길이
     * @return 각 칸마다 건널 수 있는 위치 배열. 0과 1로 구성되어 있다.
     */
    public int[] getAccessibleSpots(int size) {
        int[] accessibleSpots = new int[size];
        for (int i = 0; i < size; i++) {
            accessibleSpots[i] = bridgeNumberGenerator.generate();
        }
        return accessibleSpots;
    }

    /**
     * 숫자에 따라 위 칸 또는 아래 칸을 반환한다.
     *
     * @param number 다리의 길이
     * @return 0이면 아래칸을 의미하는 "D", 1이면 위 칸을 의미하는 "U"
     */
    private String getDirection(int number) {
        if (number == RANDOM_LOWER_INCLUSIVE) {
            return "D";
        }
        return "U";
    }

}
