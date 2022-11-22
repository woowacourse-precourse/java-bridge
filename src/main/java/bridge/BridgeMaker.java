package bridge;

import bridge.domain.gameManagement.BridgeMakingValidator;
import bridge.domain.gameManagement.BridgeState;
import bridge.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final int ZERO_COUNT = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<Integer> bridgeRandomNumbers = makeBridgeRandomNumbers(bridgeNumberGenerator, size);

        return makeUdShapedBridge(bridgeRandomNumbers);
    }

    public int takeBridgeSize() {
        InputView inputView = new InputView();
        String receivedBridgeSize = inputView.readBridgeSize();

        try {
            BridgeMakingValidator.validate(receivedBridgeSize);
            return Integer.parseInt(receivedBridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeBridgeSize();
        }
    }

    public List<Integer> makeBridgeRandomNumbers(BridgeNumberGenerator bridgeNumberGenerator, int bridgeSize) {
        List<Integer> bridgeRandomNumbers = new ArrayList<>();

        for (int bridgeLine = ZERO_COUNT; bridgeLine < bridgeSize; bridgeLine++) {
            int randomNumber = bridgeNumberGenerator.generate();
            bridgeRandomNumbers.add(randomNumber);
        }

        return bridgeRandomNumbers;
    }

    public List<String> makeUdShapedBridge(List<Integer> bridgeRandomNumbers) {
        return bridgeRandomNumbers.stream()
                .map(this::makeUdShapedRandomStateOfOneLine)
                .collect(Collectors.toList());
    }

    public String makeUdShapedRandomStateOfOneLine(int position) {
        Stream<String> randomPositionLine = Arrays.stream(BridgeState.values())
                .filter(bridgeState -> bridgeState.getMovablePositionNumber() == position)
                .map(BridgeState::getMovablePosition);

        return randomPositionLine.collect(Collectors.joining());
    }
}
