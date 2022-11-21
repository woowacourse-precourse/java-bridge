package bridge.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BridgeGameTest {
    static Stream<Arguments> MovementAndSpace() {
            return Stream.of(
                    Arguments.arguments("40", "U"),
                    Arguments.arguments("A", "D"),
                    Arguments.arguments("ㅁ", "U")
            );
        }

    @ParameterizedTest(name="U와 D 이외의 것이 입력되었을 때 예외 처리")
    @MethodSource("MovementAndSpace")
    void movementExceptionTest(String movement, String space) {
        BridgeGame bridgeGame = new BridgeGame();
        assertThrows(IllegalArgumentException.class, () -> {
            bridgeGame.move(movement, space);
        });
    }
}