package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> bridge = makeBridgeIntegerList(size);
        return bridge;
    }

    /**
     * 다리의 길이를 List<Integer>로 생성
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridgeIntegerList(int size) {
        List<Integer> bridgeRandNum = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randTempNum = bridgeNumberGenerator.generate();
            bridgeRandNum.add(randTempNum);
        }
        return makeBridgeStringList(bridgeRandNum);
    }

    /**
     * Stream API를 이용하여 0과 1을 List<String> 으로 반환
     *
     * @param bridgeNum 0과 1의 값을 가지는 List<Integer>
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public static List<String> makeBridgeStringList(List<Integer> bridgeNum) {
        return bridgeNum.stream()
                .map(BridgeMaker::randNumToString)
                .collect(Collectors.toList());
    }

    /**
     * 0 과 1을 D와 U로 반환해주는 메서드
     *
     * @param num 0과 1
     * @return D와 U
     * @throws IllegalStateException 발생
     */
    public static String randNumToString(int num) {
        if (num == 0) {
            return "D";
        }
        if (num == 1) {
            return "U";
        }
        throw new IllegalStateException("[ERROR] : 상태 값 오류가 발생하였습니다.");
    }
}
