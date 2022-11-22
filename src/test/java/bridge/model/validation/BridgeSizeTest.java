package bridge.model.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeSizeTest {
    @ParameterizedTest
    @DisplayName("3 미만 20 초과한 데이터 값")
    @ValueSource(ints = {21, 1, 38, 2})
    void incorrectData(int input) {
        assertThatThrownBy(() -> BridgeSize.checkRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정확한 값이 들어오는지 여부 확인 1")
    @Test
    void isCorrectDataCase1() {
        //given
        int input = 20;
        //when
        //then
        assertEquals(new BridgeSize(input).getBridgeSize(), 20);
    }
}

