package bridge;

import bridge.generator.BridgeNumberGenerator;

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
        validate(size);
        return toStringList(genRandomNumberList(size));
    }

    public List<String> toStringList(List<Integer> integers) {
        return integers.stream().map(i -> {
            if (i == 1) return "U";
            return "D";
        }).collect(Collectors.toList());
    }

    public List<Integer> genRandomNumberList(int size) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            integers.add(bridgeNumberGenerator.generate());
        }
        return integers;
    }

    private void validate(int size) {
        if (size < 3 || 20 < size) throw new IllegalArgumentException("숫자 범위를 잘못 입력하셨습니다.");
    }
}
