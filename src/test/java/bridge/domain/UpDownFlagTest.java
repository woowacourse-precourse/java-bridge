package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UpDownFlagTest {
    @ParameterizedTest
    @DisplayName("UpDownFlag를 생성할 때 U 또는 D 외의 입력이 들어오면 예외가 발생해야 한다.")
    @ValueSource(strings = {"0", "1", "R", "Q"})
    void createUpDownFlagByOtherString(String input) {
        // expect
        assertThatThrownBy(() -> UpDownFlag.ofString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("UpDownFlag를 생성할 때 U 또는 D 입력이 들어오면 정상적으로 생성되어야 한다.")
    @ValueSource(strings = {"U", "D"})
    void createUpDownFlagBy_U_Or_D_String(String input) {
        // expect
        assertThat(UpDownFlag.ofString(input))
                .isInstanceOf(UpDownFlag.class);
    }

    @ParameterizedTest
    @DisplayName("UpDownFlag를 생성할 때 U 또는 D 외의 입력이 들어오면 예외가 발생해야 한다.")
    @ValueSource(ints = {2, 3, 4, 5})
    void createUpDownFlagByOtherCode(int input) {
        // expect
        assertThatThrownBy(() -> UpDownFlag.codeToFlag(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0이 입력으로 들어오면 D가 반환되어야 한다.")
    void create_D_StringBy_0() {
        // expect
        assertThat(UpDownFlag.codeToFlag(0))
                .isEqualTo("D");
    }

    @Test
    @DisplayName("1이 입력으로 들어오면 U가 반환되어야 한다.")
    void create_U_StringBy_1() {
        // expect
        assertThat(UpDownFlag.codeToFlag(1))
                .isEqualTo("U");
    }
}