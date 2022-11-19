package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void TestErrorCheckReadBridgeSize() {
        assertThatThrownBy(() -> new InputView().errorCheckReadBridgeSize("j1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new InputView().errorCheckReadBridgeSize("32"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}