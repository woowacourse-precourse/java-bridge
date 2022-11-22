package bridge.model.entity;

import bridge.model.value.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.model.value.ErrorMessage.OUTRANGE_ERROR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeSizeTest {

    @DisplayName("[ERROR] BridgeSize 예외 테스트")
    @Test
    void of() {
        //Given
        String[] input = new String[] {"2", "a", "21"};
        //When
        assertThatThrownBy(() -> {
            for(int i = 0; i < input.length; i++) {
                BridgeSize.of(input[i]);
            }
        //Then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUTRANGE_ERROR);
    }
}