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

    public List<Integer> makeNumberBridge(int size) {
        List<Integer> numberBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            numberBridge.add(randomNumber);
        }
        return numberBridge;
    }

    public List<String> transferNumberToAlphabet(List<Integer> numberBridge) {
        List<String> alphabetBridge = new ArrayList<>();
        for (int i = 0; i < numberBridge.size(); i++) {
            if (numberBridge.get(i) == 0) {alphabetBridge.add("D");}
            if (numberBridge.get(i) == 1) {alphabetBridge.add("1");}
        }
        return alphabetBridge;
    }
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = transferNumberToAlphabet(makeNumberBridge(size));
        return bridge;
    }
}
