package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    private static Stream<Arguments> providePlayerMovings_And_ExpectedStatus() {
        return Stream.of(
                Arguments.of(List.of("U"), "[ O ]\n[   ]"),
                Arguments.of(List.of("U", "U"), "[ O | O ]\n[   |   ]"),
                Arguments.of(List.of("U", "U", "D"), "[ O | O |   ]\n[   |   | X ]"),
                Arguments.of(List.of("U", "U", "D", "D"), "[ O | O |   |   ]\n[   |   | X | O ]")
        );
    }

    private static Stream<Arguments> providePlayerMovings_And_RetriedStatus() {
        return Stream.of(
                Arguments.of(List.of("U"), "[  ]\n[  ]"),
                Arguments.of(List.of("U", "U"), "[  ]\n[  ]"),
                Arguments.of(List.of("U", "U", "D"), "[  ]\n[  ]"),
                Arguments.of(List.of("U", "U", "D", "D"), "[  ]\n[  ]")
        );
    }

    @BeforeEach
    void set() {
        List<String> bridge = List.of("U", "U", "U", "D");
        Player player = new Player();
        bridgeGame = new BridgeGame(bridge, player);
    }

    @DisplayName("이동 가능 여부를 예상한대로 판별하는지 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"U,true", "D,false"})
    void judgeTest(String playerMoving, boolean expected) {
        assertThat(bridgeGame.judge(playerMoving)).isEqualTo(expected);
    }

    @DisplayName("이동 후, 플레이어 상태가 업데이트 되는지 확인 테스트")
    @ParameterizedTest
    @MethodSource("providePlayerMovings_And_ExpectedStatus")
    void moveTest(List<String> playerMovings, String expectedStatus) {
        for (String playingMoving : playerMovings) {
            bridgeGame.move(playingMoving);
        }
        assertThat(bridgeGame.getPlayerStatus()).contains(expectedStatus);
    }

    @DisplayName("retry시, 플레이어 상태 테스트")
    @ParameterizedTest
    @MethodSource("providePlayerMovings_And_RetriedStatus")
    void retryTest(List<String> playerMovings, String expectedStatus) {
        for (String playingMoving : playerMovings) {
            bridgeGame.move(playingMoving);
        }
        bridgeGame.retry();
        assertThat(bridgeGame.getPlayerStatus()).contains(expectedStatus);
    }

}
