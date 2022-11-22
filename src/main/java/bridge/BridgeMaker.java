package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeMaker {

    private static final String MOVE_UP_COMMAND = "U";
    private static final String MOVE_DOWN_COMMAND = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(final BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
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
