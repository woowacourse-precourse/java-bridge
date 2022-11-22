package bridge.model;

import bridge.model.utils.BridgeSides;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private static final BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"), 1);

    @DisplayName("위 다리로 이동한 경로를 반환한다")
    @ParameterizedTest
    @MethodSource("moveUpSideTestSource")
    void moveUpSideTest(int distance, PlayerMap expected) {
        TotalResult actual = bridgeGame.move(BridgeSides.up(), distance);
        assertThat(actual.getPlayerMap()).isEqualTo(expected);
    }

    @DisplayName("위 다리로 이동한 경로를 반환한다")
    @ParameterizedTest
    @MethodSource("moveDownSideTestSource")
    void moveDownSideTest(int distance, PlayerMap expected) {
        TotalResult actual = bridgeGame.move(BridgeSides.down(), distance);
        assertThat(actual.getPlayerMap()).isEqualTo(expected);
    }

    @DisplayName("게임을 n번 재시작하면 총 시도 횟수 (n + 1)을 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3})
    void retryTest(int retry) {
        BridgeGame nextBridgeGame = bridgeGame;
        for (int i = 0; i < retry; i++) {
            nextBridgeGame = nextBridgeGame.retry();
        }

        TotalResult actual = nextBridgeGame.move("D", 1);
        assertThat(actual.getTryCnt()).isEqualTo(retry + 1);
    }

    private static Stream<Arguments> moveUpSideTestSource() {
        return Stream.of(
                Arguments.of(1, new PlayerMap(
                        List.of("O"),
                        List.of(" ")
                )),
                Arguments.of(2, new PlayerMap(
                        List.of("O", "X"),
                        List.of(" ", " ")
                )),
                Arguments.of(3, new PlayerMap(
                        List.of("O", " ", "X"),
                        List.of(" ", "O", " ")
                ))
        );
    }

    private static Stream<Arguments> moveDownSideTestSource() {
        return Stream.of(
                Arguments.of(1, new PlayerMap(
                        List.of(" "),
                        List.of("X")
                )),
                Arguments.of(2, new PlayerMap(
                        List.of("O", " "),
                        List.of(" ", "O")
                )),
                Arguments.of(3, new PlayerMap(
                        List.of("O", " ", " "),
                        List.of(" ", "O", "O")
                ))
        );
    }

}
