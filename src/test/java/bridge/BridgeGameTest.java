package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D", "D", "U", "D"));

    @DisplayName("한칸 이동 성공 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"U","D","D","D","U","D"})
    void 한칸이동_성공_테스트(String direction) {
        assertTrue(bridgeGame.move(direction));
    }

    @DisplayName("한칸 이동 실패 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"D","U","U","U","D","U"})
    void 한칸이동_실패_테스트(String direction) {
        assertFalse(bridgeGame.move(direction));
    }
}