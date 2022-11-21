package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.CompareBridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CompareBridgeTest {

    @DisplayName("위쪽 다리 테스트")
    @ParameterizedTest
    @CsvSource({"U, U, O", "U, D, ' '", "D, U, ' '", "D, D, O"})
    void getUpSideMove(CompareBridge playerMove, String bridgeElement, String exception) {
        assertThat(playerMove.getUpSideMove(playerMove, bridgeElement))
                .toString()
                .contains(exception);
    }

    @DisplayName("아래쪽 다리 테스트")
    @ParameterizedTest
    @CsvSource({"U, U, ' '", "U, D, ' '", "D, U, X", "D, D, O"})
    void getDownSideMove(CompareBridge playerMove, String bridgeElement, String exception) {
        assertThat(playerMove.getUpSideMove(playerMove, bridgeElement))
                .toString()
                .contains(exception);
    }
}