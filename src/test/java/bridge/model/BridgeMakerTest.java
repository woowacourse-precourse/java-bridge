package bridge.model;

import bridge.controller.BridgeController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    @DisplayName("다리의 길이가 맞지 않는 범위 라면 예외 처리.")
    @ParameterizedTest
    @CsvSource({"-1", "2", "21", "20000"})
    void validateBridgeLengthByOverSize(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThatThrownBy(() -> bridgeMaker.validateSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}