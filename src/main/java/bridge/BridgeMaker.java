package bridge;

import java.util.List;
import java.util.Random;

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
        int index = 17;
        int turn = 17;
        int life = 16;
        boolean[][] arr_bool = new boolean[18][2];
        String[][] arr_glass = new String[18][2];
        for (int i = 0; i < arr_bool.length; i++) {
            arr_bool[i][0] = new Random().nextBoolean();
            arr_bool[i][1] = !arr_bool[i][0];
            for (int j = 0; j < arr_bool[i].length; j++) {
                arr_glass[i][j] = "□";
            };
        }
        return null;
    }

}
