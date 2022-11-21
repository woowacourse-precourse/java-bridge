package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CrossStateTest {

    @DisplayName("사용자의 움직임은 건널 수 있다면 O, 없다면 X 상태값을 가지고, 사용자가 이동할 칸이 아닌 경우 빈 값을 가진다.")
    @ParameterizedTest
    @MethodSource("parametersProvider")
    void 사용자의_이동위치와_건너기_가능_여부에_띠른_상태값_계산(boolean isSameBridgeMovement, boolean isCrossable, CrossState expected) {
        assertThat(CrossState.findByStatus(isSameBridgeMovement, isCrossable)).isEqualTo(expected);
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments(true, true, CrossState.SUCCESS),
                arguments(true, false, CrossState.FAILED),
                arguments(false, true, CrossState.NONE),
                arguments(false, false, CrossState.NONE)
        );
    }

}