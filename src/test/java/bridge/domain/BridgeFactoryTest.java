package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeFactoryTest {

    @ParameterizedTest(name = "다리 생성시 잘못된 값이 입력되면 오류가 발생한다")
    @MethodSource
    void fromThrowsError(BridgeLength brideLength, List<BridgeMove> moves, Exception e) {
        assertThatThrownBy(() -> BridgeFactory.from(brideLength, moves))
                .isInstanceOf(e.getClass())
                .hasMessageContaining(e.getMessage());
    }

    private static Stream<Arguments> fromThrowsError() {
        NullPointerException nullPointerException = new NullPointerException("다리의 길이는 null이 될 수 없습니다.");
        NullPointerException containsNullException = new NullPointerException("다리의 각 칸은 U,D 중 하나의 값을 가져야 합니다");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("다리의 길이와 칸의 개수는 같아야 합니다.");

        List<BridgeMove> movesSizeOutOfRange = new ArrayList<>();
        for (int count = 1; count <= 21; count++) {
            movesSizeOutOfRange.add(BridgeMove.UP);
        }

        List<BridgeMove> stepsContainingNull = new ArrayList<>();
        stepsContainingNull.add(BridgeMove.UP);
        stepsContainingNull.add(BridgeMove.UP);
        stepsContainingNull.add(null);

        return Stream.of(
                Arguments.of(new BridgeLength(20), movesSizeOutOfRange, illegalArgumentException),
                Arguments.of(null, List.of(BridgeMove.UP, BridgeMove.DOWN), nullPointerException),
                Arguments.of(new BridgeLength(stepsContainingNull.size()), stepsContainingNull, containsNullException),
                Arguments.of(new BridgeLength(3), List.of(), illegalArgumentException));
    }

    @ParameterizedTest(name = "주어진 리스트를 활용해 다리를 생성한다")
    @MethodSource
    void fromReturnBridge(List<BridgeMove> steps, int expectedSize) {
        int actualSize = BridgeFactory.from(new BridgeLength(steps.size()), steps).getBridgeLength().getLength();
        assertThat(actualSize).isEqualTo(expectedSize);
    }

    private static Stream<Arguments> fromReturnBridge() {
        return Stream.of(
                Arguments.of(Arrays.asList(BridgeMove.UP, BridgeMove.DOWN, BridgeMove.DOWN), 3),
                Arguments.of(Arrays.asList(BridgeMove.UP, BridgeMove.DOWN, BridgeMove.DOWN, BridgeMove.DOWN), 4));
    }
}