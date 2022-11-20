package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import bridge.domain.bridge.Bridge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeLocationTest {

    @ParameterizedTest
    @CsvSource({"-3, 0, -123"})
    void 범위_예외_테스트(int value) {
        assertThatThrownBy(() -> new BridgeLocation(value)).isInstanceOf(IllegalArgumentException.class);
    }

}