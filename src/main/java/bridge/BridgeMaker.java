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

    public List<String> makeBridge(int size) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <size; i++) {
            result.add(UpOrDown.valueToOut(bridgeNumberGenerator.generate()));
        }
        return result;
    }

}
enum UpOrDown{
    UP("U",1),
    DOWN("D", 0);

    String out;
    int value;


    UpOrDown(String out, int value) {
        this.out = out;
        this.value = value;
    }

    static String valueToOut(int value) {
        if (value == 0) {
            return DOWN.out;
        } else if (value == 1) {
            return UP.out;
        }
        return null;
    }
}
