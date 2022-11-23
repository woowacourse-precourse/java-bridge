package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveSpaceTest {

    @Test
    @DisplayName("move space validation test")
    void validateMovingTest() {
        assertThatThrownBy(() ->new MoveSpace("S"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}