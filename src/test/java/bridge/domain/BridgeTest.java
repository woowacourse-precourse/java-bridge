package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


class BridgeTest {

    @DisplayName("BridgeMaker를 통해 생성된 다리가 정상적으로 할당된다")
    @Test
    void setBridgeWithBridgeMaker() {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int expectedSize = 3;

        // when
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(expectedSize));

        // then
        assertThat(bridge.getSize()).isEqualTo(expectedSize);
    }

    @DisplayName("U, D 이외의 알파벳을 가진 다리가 할당되면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("generateData")
    void createBridgeWithWrongConditionBridge(List<String> steps) {
        assertThatThrownBy(() -> new Bridge(steps))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("U, D 이외의 방향을 가질 수 없습니다.");
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList("A", "B", "A")),
                Arguments.of(Arrays.asList("1", "2", "3"))
        );
    }

    @DisplayName("해당 위치에서 다리를 지날 수 있는 경우 true를 반환한다")
    @Test
    void createSuccessMovingWithBridge() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        String firstMoving = "U";

        // when
        boolean firstMovingFlag = bridge.canMove(0, firstMoving);

        // then
        assertThat(firstMovingFlag).isEqualTo(true);
    }

    @DisplayName("해당 위치에서 다리를 지날 수 없는 경우 false를 반환한다")
    @Test
    void createFailMovingWithBridge() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        String firstMoving = "D";

        // when
        boolean firstMovingFlag = bridge.canMove(0, firstMoving);

        // then
        assertThat(firstMovingFlag).isEqualTo(false);
    }

    @DisplayName("사용자의 위치가 다리의 크기보다 큰 경우 예외가 발생한다.")
    @Test
    void createMovingWithWrongPosition() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        String moving = "U";
        int position = 3;

        // when, then
        assertThatThrownBy(() -> bridge.canMove(position, moving))
                .isInstanceOf(IllegalArgumentException.class);
    }
}