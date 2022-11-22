package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BridgeStateTest {

    @DisplayName("사용자의 이동 방향과 정답여부에 따라 다리의 상태가 업데이트 된다.")
    @MethodSource("updateArguments")
    @ParameterizedTest
    void 사용자의_이동_방향과_정답여부에_따라_다리의_상태가_올바르게_수정되는_경우(String direction, String resultOfMoving, int iterCount) {
        // given
        BridgeState bridgeState = new BridgeState();

        // when
        for (int i = 0; i < iterCount; i++) {
            bridgeState.updateStateOfBridge(direction, resultOfMoving);
        }

        // then
        List<String> rightDirectionsOfBridge = bridgeState.getRightDirectionsOfBridge();
        List<String> markingOfUserMovings = bridgeState.getMarkingsOfUserMoving();

        assertThat(rightDirectionsOfBridge).hasSize(iterCount);
        assertThat(markingOfUserMovings).hasSize(iterCount);

        assertThat(rightDirectionsOfBridge).contains(direction);
        assertThat(markingOfUserMovings).contains(resultOfMoving);
    }

    @DisplayName("다리 상태(사용자의 이동방향, 사용자의 움직임에 따른 정답 여부)의 모든 정보를 비운다.")
    @MethodSource("updateArguments")
    @ParameterizedTest
    void 다리의_모든_정보를_비우는_경우(String direction, String resultOfMoving, int iterCount) {
        // given
        BridgeState bridgeState = new BridgeState();

        for (int i = 0; i < iterCount; i++) {
            bridgeState.updateStateOfBridge(direction, resultOfMoving);
        }

        // when
        bridgeState.clearAllBridgeState();

        // then
        assertThat(bridgeState.getRightDirectionsOfBridge()).isEmpty();
        assertThat(bridgeState.getMarkingsOfUserMoving()).isEmpty();
    }

    private static Stream<Arguments> updateArguments() {
        return Stream.of(
                arguments("U", "O", 3),
                arguments("D", "O", 4),
                arguments("D", "O", 10)
        );
    }
}