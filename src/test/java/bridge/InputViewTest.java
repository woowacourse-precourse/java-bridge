package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 크기 입력 예외 테스트")
    @Test
    void isInRange() {
        final InputView inputview = new InputView();
        final int sizeMin = 0;
        final int sizeMax = Integer.MAX_VALUE;

        final boolean checkMin = inputview.isInRange(sizeMin);
        final boolean checkMax = inputview.isInRange(sizeMax);

        assertThat(checkMin).isFalse();
        assertThat(checkMax).isTrue();
    }

    @DisplayName("문자열을 정수로 바꿀 때 예외 처리")
    @Test
    void stringToInteger() {
        final InputView inputView = new InputView();
        final String input = "1000j";

        assertThatThrownBy(() -> inputView.stringToInteger(input)).isInstanceOf(IllegalArgumentException.class);
    }
}