package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
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
    void moveUpSideTest(int distance, RouteMap expected) {
        TotalResult actual = bridgeGame.move("U", distance);
        assertThat(actual.getRouteMap()).isEqualTo(expected);
    }

    @DisplayName("위 다리로 이동한 경로를 반환한다")
    @ParameterizedTest
    @MethodSource("moveDownSideTestSource")
    void moveDownSideTest(int distance, RouteMap expected) {
        TotalResult actual = bridgeGame.move("D", distance);
        assertThat(actual.getRouteMap()).isEqualTo(expected);
    }

    @DisplayName("게임을 2번 재시작하면 총 시도 횟수 3을 반환한다")
    @Test
    void retryTest() {
        BridgeGame nextBridgeGame = bridgeGame.retry();
        nextBridgeGame = nextBridgeGame.retry();

        TotalResult actual = nextBridgeGame.move("D", 1);
        assertThat(actual.getTryCnt()).isEqualTo(3);
    }

    private static Stream<Arguments> moveUpSideTestSource() {
        return Stream.of(
                Arguments.of(1, new RouteMap(
                        List.of("O"),
                        List.of(" ")
                )),
                Arguments.of(2, new RouteMap(
                        List.of("O", "X"),
                        List.of(" ", " ")
                )),
                Arguments.of(3, new RouteMap(
                        List.of("O", " ", "X"),
                        List.of(" ", "O", " ")
                ))
        );
    }

    private static Stream<Arguments> moveDownSideTestSource() {
        return Stream.of(
                Arguments.of(1, new RouteMap(
                        List.of(" "),
                        List.of("X")
                )),
                Arguments.of(2, new RouteMap(
                        List.of("O", " "),
                        List.of(" ", "O")
                )),
                Arguments.of(3, new RouteMap(
                        List.of("O", " ", " "),
                        List.of(" ", "O", "O")
                ))
        );
    }

}
