package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BridgeExceptionTest {

    private final BridgeException bridgeException = new BridgeException();

    @Test
    @DisplayName("다리의 입력이 null인지 확인하는 테스트")
    public void isNullTest() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> bridgeException.isNull(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리의 길이가 숫자인지 확인하는 테스트")
    public void isNumberTest() {
        // given
        String input = "aa";

        // when, then
        assertThatThrownBy(() -> bridgeException.isNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리의 길이가 범위 내에 있는지 확인하는 테스트")
    public void isInRangeTest() {
        // given
        String input = "100";

        // when, then
        assertThatThrownBy(() -> bridgeException.isInRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}