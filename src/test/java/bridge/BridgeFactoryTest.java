package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.BridgeFactory;
import bridge.domain.BridgeSize;
import bridge.domain.BridgeStep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeFactoryTest {

    @ParameterizedTest
    @MethodSource
    void fromThrowsError(BridgeSize size, List<BridgeStep> steps, Exception e) {
        assertThatThrownBy(() -> BridgeFactory.from(size, steps))
                .isInstanceOf(e.getClass())
                .hasMessageContaining(e.getMessage());
    }

    private static Stream<Arguments> fromThrowsError() {
        NullPointerException nullPointerException = new NullPointerException("다리의 길이는 null이 될 수 없습니다.");
        NullPointerException containsNullException = new NullPointerException("다리의 각 칸은 U,D 중 하나의 값을 가져야 합니다");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("다리의 길이와 칸의 개수는 같아야 합니다.");

        List<BridgeStep> stepsSizeOutOfRange = new ArrayList<>();
        for (int count = 1; count <= 21; count++) {
            stepsSizeOutOfRange.add(BridgeStep.UP);
        }

        List<BridgeStep> stepsContainingNull = new ArrayList<>();
        stepsContainingNull.add(BridgeStep.UP);
        stepsContainingNull.add(BridgeStep.UP);
        stepsContainingNull.add(null);

        return Stream.of(
                Arguments.of(new BridgeSize(20), stepsSizeOutOfRange, illegalArgumentException),
                Arguments.of(null, List.of(BridgeStep.UP, BridgeStep.DOWN), nullPointerException),
                Arguments.of(new BridgeSize(stepsContainingNull.size()), stepsContainingNull, containsNullException),
                Arguments.of(new BridgeSize(3), List.of(), illegalArgumentException));
    }

    @ParameterizedTest
    @MethodSource
    void fromReturnBridge(List<BridgeStep> steps, int expectedSize) {
        int actualSize = BridgeFactory.from(new BridgeSize(steps.size()), steps).size();
        assertThat(actualSize).isEqualTo(expectedSize);
    }

    private static Stream<Arguments> fromReturnBridge() {
        return Stream.of(
                Arguments.of(Arrays.asList(BridgeStep.UP, BridgeStep.DOWN, BridgeStep.DOWN), 3),
                Arguments.of(Arrays.asList(BridgeStep.UP, BridgeStep.DOWN, BridgeStep.DOWN, BridgeStep.DOWN), 4));
    }
}