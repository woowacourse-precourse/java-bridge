package bridge.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @DisplayName("생성자 메소드에 0 혹은 음수를 입력했을 때 오류를 발생시키는지 확인")
    @ParameterizedTest(name = "{index} : {0} 입력 시, 오류 발생")
    @ValueSource(ints = {0, -1, -2})
    void constructor_error_test(int number) {
        assertThatThrownBy(() -> new Round(number)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 잘못된 게임 라운드 입니다.");
    }

    @DisplayName("생성자 메소드에 int 범위의 양수 숫자를 입력했을 때 Round 객체가 생성되는지 확인")
    @ParameterizedTest(name = "{index} : {0} 입력 시, 객체 생성")
    @ValueSource(ints = {1, 5, 2_147_483_647})
    void constructor_test(int number) {
        Round round = new Round(number);

        assertThat(round).isInstanceOf(Round.class);
    }
}