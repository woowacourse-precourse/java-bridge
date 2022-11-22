package bridge.model;

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
    //1과 0은 매직넘버이므로 상수를 사용해하는데 BridgeRandomNumberGenerator에서 private static final로 선언되어 있어 사용못함.(수정 필요)
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for(int i = 0; i < size; i++){
            int number = bridgeNumberGenerator.generate();
            if(number == 1){
                bridge.add("U");
            }else if(number == 0){
                bridge.add("D");
            }
        }
        return bridge;
    }
}
