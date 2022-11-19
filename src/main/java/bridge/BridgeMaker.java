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

    // 다리 길이에 따라 0,1 을 무작위로 추출하는 기능
    private List<Integer> makeBridgeInteger(int size) {
        List<Integer> numberList = new ArrayList<>();
        while (size != 0) {
            int number = bridgeNumberGenerator.generate();
            numberList.add(number);
            size -= 1;
        }
        return numberList;
    }


}
