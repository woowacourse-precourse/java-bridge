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
    // 인자, 이름, 반환 타입이 변경 불가한 메서드
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            bridge.add("[   ]");
        }
        return bridge;
    }

    public boolean isBridgeSize(List<String> bridge, int bridgeSize){
        if(bridge.size() >= bridgeSize){
            return true;
        }
        return false;
    }


    // BridgeMaker를 선언하는 곳에서 구현해야 함
    public int bridgeRandomNumber() {
        int randomNumber = bridgeNumberGenerator.generate();
        return randomNumber;
    }
}
