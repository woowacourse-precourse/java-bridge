package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


class BridgeTest {

    @DisplayName("BridgeMaker를 통해 생성된 다리가 정상적으로 할당된다")
    @ParameterizedTest
    @ValueSource(ints = {3, 9, 15})
    void setBridgeWithBridgeMaker(int size) {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // when
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));

        // then
        assertThat(bridge.getSize()).isEqualTo(size);
    }

    @DisplayName("U, D 이외의 알파벳을 가진 다리가 할당되면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("generateStepData")
    void createBridgeWithWrongConditionBridge(List<String> steps) {
        assertThatThrownBy(() -> new Bridge(steps))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("U, D 이외의 방향을 가질 수 없습니다.");
    }

    static Stream<Arguments> generateStepData() {
        return Stream.of(
                Arguments.of(Arrays.asList("A", "B", "A")),
                Arguments.of(Arrays.asList("1", "2", "3"))
        );
    }

    @DisplayName("해당 위치에서 다리를 지날 수 있으면 true, 없으면 false를 반환한다")
    @ParameterizedTest
    @MethodSource("generateMovingAndPositionData")
    void createFailMovingWithBridge(String moving, int position, boolean passedFlag) {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        // when
        boolean movingFlag = bridge.canMove(position, moving);

        // then
        assertThat(movingFlag).isEqualTo(passedFlag);
    }

    static Stream<Arguments> generateMovingAndPositionData() {
        return Stream.of(
                Arguments.of("U", 0, true),
                Arguments.of("D", 1, true),
                Arguments.of("D", 2, false)
        );
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