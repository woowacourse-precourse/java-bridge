package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private List<String> makeBridgeList;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    // 다리 길이에 따라 랜덤 list를 최종 저장하는 기능
    public List<String> makeBridge(int size) {
        List<Integer> numberList = makeBridgeInteger(size);
        this.makeBridgeList = intBridgeToStringBridge(numberList);
        return makeBridgeList;
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

    // 0,1로 저장되어있는 list를 D,U list로 변환시켜주는 기능
    private List<String> intBridgeToStringBridge(List<Integer> numberList) {
        List<String> bridgeStringList = new ArrayList<>();
        for(int num : numberList) {
            if(num == 0) {
                bridgeStringList.add("D");
            }
            if(num == 1) {
                bridgeStringList.add("U");
            }
        }
        return bridgeStringList;
    }

}
