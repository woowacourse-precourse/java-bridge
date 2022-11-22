package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final NumberShape numbershape = new NumberToString();
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     *
        ex) makeBridge(3) => return List.of("U","D","U"); 가 되야하는듯.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        String randomUpDown = null;
        for(int i = 0;i < size ; i++){
            randomUpDown = makeRandomUpDown();
            bridge.add(randomUpDown);
        }
        return bridge;
    }
    public String makeRandomUpDown(){
        int random  = -1;
        random = bridgeNumberGenerator.generate();
        return numbershape.numToUpDown(random);
    }

}
