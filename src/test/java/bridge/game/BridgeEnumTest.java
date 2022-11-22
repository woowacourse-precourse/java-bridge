package bridge.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeEnumTest {

    @DisplayName("1의 데이터가 들어오면 U를 반환한다")
    @Test
    void enumTest_top() {
        // given
        int input = 1;
        String result = "U";

        // when
        String division = BridgeEnum.getDivision(input);

        // then
        assertThat(division)
                .isEqualTo(result);
    }

    @DisplayName("0의 데이터가 들어오면 D를 반환한다")
    @Test
    void enumTest_bottom() {
        // given
        int input = 0;
        String result = "D";

        // when
        String division = BridgeEnum.getDivision(input);

        // then
        assertThat(division)
                .isEqualTo(result);
    }

    @DisplayName("1과 0의 데이터가 아니면 에러가 발생한다.")
    @ValueSource(strings = {"2", "3", "4", "6", "10"})
    @ParameterizedTest
    void enumTest_error(Integer input) {
        assertThatThrownBy(() -> BridgeEnum.getDivision(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}