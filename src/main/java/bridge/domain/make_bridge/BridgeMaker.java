package bridge.domain.make_bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * TODO 필드(인스턴스 변수) 변경 불가!!!!!!
 * TODO 메서드의 시그니처(인자, 이름)와 반환 타입은 변경 불가!!!!!
 */
public class BridgeMaker {

    private static final String MOVE_UP_COMMAND = "U";
    private static final String MOVE_DOWN_COMMAND = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(final BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(final int size) {
        List<Integer> randomNumbers = randomNumbers(size);
        return randomNumbers.stream()
                .map(this::moveCommand)
                .collect(Collectors.toList());
    }

    private List<Integer> randomNumbers(final int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> bridgeNumberGenerator.generate())
                .collect(Collectors.toList());
    }

    private String moveCommand(final int randomNumber) {
        final int NUMBER_FOR_MOVE_UP = 1;
        if (randomNumber == NUMBER_FOR_MOVE_UP) {
            return MOVE_UP_COMMAND;
        }

        return MOVE_DOWN_COMMAND;
    }
}
