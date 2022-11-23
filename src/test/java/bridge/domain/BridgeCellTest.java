package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeCellTest {

    private static String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("숫자에 맞는 다리 칸을 반환한다.")
    @ParameterizedTest
    @EnumSource(BridgeCell.class)
    void getBridgeCellByNumber(BridgeCell cell) {
        assertThat(BridgeCell.getBridgeCell(cell.getNumber())).isEqualTo(cell);
    }

    @DisplayName("숫자 입력이 잘못되면 예외가 발생한다.")
    @Test
    void getBridgeCellByInvalidNumber() {
        assertThatThrownBy(() -> BridgeCell.getBridgeCell(12))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("시그니처에 맞는 다리 칸을 반환한다.")
    @ParameterizedTest
    @EnumSource(BridgeCell.class)
    void getBridgeCellBySignature(BridgeCell cell) {
        assertThat(BridgeCell.getBridgeCell(cell.getSignature())).isEqualTo(cell);
    }

    @DisplayName("시그니처 입력이 잘못되면 예외가 발생한다.")
    @Test
    void getBridgeCellByInvalidSignature() {
        assertThatThrownBy(() -> BridgeCell.getBridgeCell("d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
