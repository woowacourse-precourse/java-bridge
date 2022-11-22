package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerStatusTest {
    private final PlayerStatus playerStatus = new PlayerStatus();

    private static Stream<Arguments> provideMovingResult_PlayerMoving_Expected() {
        return Stream.of(
                Arguments.of(List.of(true), List.of("U"), "[ O ]\n[   ]"),
                Arguments.of(List.of(true, true), List.of("U", "U"), "[ O | O ]\n[   |   ]"),
                Arguments.of(
                        List.of(true, true, false), List.of("U", "U", "D"), "[ O | O |   ]\n[   |   | X ]")
        );
    }

    @BeforeEach
    void set() {
        playerStatus.setDefault();
    }

    @DisplayName("업데이트와 toString이 예상한대로인지 테스트")
    @ParameterizedTest
    @MethodSource("provideMovingResult_PlayerMoving_Expected")
    void updatePlayerStatusMapTest(List<Boolean> movingResults, List<String> playerMovings, String expected) {
        for (int i = 0; i < playerMovings.size(); i++) {
            playerStatus.update(movingResults.get(i), playerMovings.get(i));
        }

        assertThat(playerStatus.toString()).isEqualTo(expected);
    }

}
