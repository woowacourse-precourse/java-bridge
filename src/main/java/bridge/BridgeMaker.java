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
    // Test 완료, README 완료
    public List<String> makeBridge(int size) {
        List<Integer> bridgeNumber = makeBridgeNumber(size); // 다리 숫자 생성
        List<String> bridgeList = new ArrayList<>();

        for (int number : bridgeNumber) {
            String bridgeWord = makeBridgeWord(number);
            bridgeList.add(bridgeWord);
        }
        return bridgeList;
    }


    public List<Integer> makeBridgeNumber(int size) {
        List<Integer> bridgeNumber = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridgeNumber.add(bridgeNumberGenerator.generate());
        }
        return bridgeNumber;
    }

    public String makeBridgeWord(int bridgeNumber) {
        if (bridgeNumber == 1) {
            return "U";
        }
        return "D";
    }

}
