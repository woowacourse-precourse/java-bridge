package bridge.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = BridgeGame.getBridgeGame();
    }

    @DisplayName("move메소드를 통해서 user의 정보가 잘 변화하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"U"})
    void testMove(String input) {
        bridgeGame.move(input);
        assertEquals(bridgeGame.user, List.of("U"));

    }
}