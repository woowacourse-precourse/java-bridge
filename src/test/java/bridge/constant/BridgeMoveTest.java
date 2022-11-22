package bridge.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMoveTest {

    @ParameterizedTest
    @ValueSource(strings = {"d", "u", "", " ", "a", "da", "ua"})
    void findByInputByNotExist(String input) {
        // when
        BridgeMove bridgeMove = BridgeMove.findByInput(input);

        // then
        assertThat(bridgeMove).isEqualTo(BridgeMove.MISS);
    }

    @ParameterizedTest
    @ValueSource(strings = {"D"})
    void findByInputByDOWNExist(String input) {
        // when
        BridgeMove bridgeMove = BridgeMove.findByInput(input);

        // then
        assertThat(bridgeMove).isEqualTo(BridgeMove.DOWN);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U"})
    void findByInputByUPExist(String input) {
        // when
        BridgeMove bridgeMove = BridgeMove.findByInput(input);

        // then
        assertThat(bridgeMove).isEqualTo(BridgeMove.UP);
    }

    @Test
    void equalFirstLetterWithInputByDOWN() {
        // given
        String input = "D";
        BridgeMove bridgeMove = BridgeMove.DOWN;

        // when
        boolean result = bridgeMove.equalFirstLetterWithInput(input);

        // then
        assertTrue(result);
    }

    @Test
    void equalFirstLetterWithInputBYUP() {
        // given
        String input = "U";
        BridgeMove bridgeMove = BridgeMove.UP;

        // when
        boolean result = bridgeMove.equalFirstLetterWithInput(input);

        // then
        assertTrue(result);
    }

    @Test
    void isMiss() {
        // given
        BridgeMove bridgeMove = BridgeMove.MISS;

        // when
        boolean miss = bridgeMove.isMiss();

        // then
        assertTrue(miss);
    }

    @Test
    void isMissByNotMiss() {
        // given
        BridgeMove bridgeMove = BridgeMove.UP;

        // when
        boolean miss = bridgeMove.isMiss();

        // then
        assertFalse(miss);
    }
}