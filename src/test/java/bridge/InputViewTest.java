package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView=new InputView();

    @DisplayName("다리 길이 숫자 아니면 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings={"abc","a12","1a2b","123a","!!@"})
    public void checkDigitTest(String input) {
        assertThatThrownBy(()->inputView.checkDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 3~20 사이 숫자 아니면 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings={"123","2","-3","50","21"})
    void checkRangeTest(int input) {
        assertThatThrownBy(()->inputView.checkRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readMovingTest() {
    }

    @Test
    void readGameCommandTest() {
    }
}