package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    private final Player player = new Player();
    private final List<String> bridge = List.of("U", "U", "D", "D");

    private static Stream<Arguments> provideMovingResult_PlayerMoving_Expected() {
        return Stream.of(
                Arguments.of(List.of(true), List.of("U"), false),
                Arguments.of(List.of(true, true, true, true), List.of("U", "U", "D", "D"), true),
                Arguments.of(List.of(true, true, true, false), List.of("U", "U", "D", "U"), false)
        );
    }

    @DisplayName("플레이어가 다리 끝에 성공적으로 도착했는지 여부 확인 테스트")
    @ParameterizedTest
    @MethodSource("provideMovingResult_PlayerMoving_Expected")
    void isArrivedTest(List<Boolean> movingResult, List<String> playerMoving, boolean expected) {
        for (int i = 0; i < movingResult.size(); i++) {
            player.updatePlayerStatus(movingResult.get(i), playerMoving.get(i));
        }

        assertThat(player.isArrived(bridge.size())).isEqualTo(expected);
    }
}
