package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewValidateTest {
    @DisplayName("사이즈가 숫자만 입력되었는가.")
    @Test
    void inputSizeTest(){
        assertThatThrownBy(() -> InputViewValidate.inputSizeValidate("123j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사이즈 범위가 3~20 인가.")
    @Test
    void inputSizeRangeTest(){
        // 이 예외처리는 InputSize 예외 통과 이후에 진행되므로 숫자만 입력된다.
        assertThatThrownBy(() -> InputViewValidate.sizeValidate(123))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U와 D만 입력되었는가")
    @Test
    void inputMoveTest(){
        assertThatThrownBy(() -> InputViewValidate.inputMoveValidate("K"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R과 Q만 입력되었는가")
    @Test
    void inputCommandTest(){
        assertThatThrownBy(() -> InputViewValidate.inputCommandValidate("J"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}