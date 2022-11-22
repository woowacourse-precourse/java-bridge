package bridge.model.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UpAndDownTest {

    @DisplayName("[ERROR] UpAndDownTest 예외 테스트")
    @Test
    void getDirection() {
        //Given
        int input = 3;
        //When

        assertThatThrownBy(() -> {
            UpAndDown.getDirection(3);
        //Then

        }).isInstanceOf(IllegalArgumentException.class);
    }
}