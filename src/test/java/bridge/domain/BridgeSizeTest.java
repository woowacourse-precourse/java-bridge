package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class BridgeSizeTest {

    @Test
    void validateRangeOfSize() {
        String minInput = "1";
        assertThatThrownBy(() -> new BridgeSize(minInput))
                .isInstanceOf(IllegalArgumentException.class);

        String maxInput = "31";
        assertThatThrownBy(() -> new BridgeSize(maxInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNoSuchException() {
        String input = "a";
        assertThatThrownBy(() -> new BridgeSize(input))
                .isInstanceOf(NoSuchElementException.class);
    }
}