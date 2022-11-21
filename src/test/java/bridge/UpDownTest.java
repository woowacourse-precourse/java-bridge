package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpDownTest {

    @Test
    void numberToLetterTest() {
        Assertions.assertThat(UpDown.numberToLetter(0)).isEqualTo("D");
        Assertions.assertThat(UpDown.numberToLetter(1)).isEqualTo("U");
    }
}