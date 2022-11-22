package bridge;

import bridge.validation.Validation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    Validation validation = new Validation();

    @Test
    void bridgeSizeIsInRangeTest() {
        assertThatThrownBy(() -> validation.bridgeSizeIsInRange(1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validation.bridgeSizeIsInRange(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void moveUOrD() {
        assertThatThrownBy(() -> validation.moveIsUOrD("hvyuhgh"))
                .isInstanceOf(IllegalArgumentException.class);

        validation.moveIsUOrD("U");
        validation.moveIsUOrD("D");
    }

    @Test
    void quitOrRestart() {
        assertThatThrownBy(() -> validation.quitOrRestart("D"))
                .isInstanceOf(IllegalArgumentException.class);

        validation.quitOrRestart("Q");
        validation.quitOrRestart("R");
    }
}
