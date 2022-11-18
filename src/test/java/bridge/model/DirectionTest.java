package bridge.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {
    @Test
    @DisplayName("랜덤으로 만들어진 숫자가 0이면 D, 1이면 U가 반환된다.")
    void getDirectionByNumber_NumberIs0Or1_ReturnDOrU() {
        assertThat(Direction.getDirectionByNumber(0)).isEqualTo("D");
        assertThat(Direction.getDirectionByNumber(1)).isEqualTo("U");
    }

}