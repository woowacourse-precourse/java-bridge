package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {
    private static final String INVALID_LENGTH_RANGE_MESSAGE = "[ERROR] 다리 길이는 3이상 20이하의 숫자를 입력해주세요.";

    @DisplayName("다리 길이가 3미만일 경우 예외가 발생하는지 테스트")
    @Test
    void validateLengthRangeByUnder3() {
        assertThatThrownBy(() -> {
                      new Bridge(2);
                  })
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageContaining(INVALID_LENGTH_RANGE_MESSAGE);
    }

    @DisplayName("다리 길이가 20초과일 경우 예외가 발생하는지 테스트")
    @Test
    void validateLengthRangeByOver20() {
       assertThatThrownBy(() -> {
            new Bridge(21);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LENGTH_RANGE_MESSAGE);
    }
}