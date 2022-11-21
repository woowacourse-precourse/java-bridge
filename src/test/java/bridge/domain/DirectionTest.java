package bridge.domain;

import static bridge.domain.Direction.UP;
import static bridge.domain.Direction.toCommand;
import static bridge.domain.Direction.toEnum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Direction Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DirectionTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 3})
    void toCommand_메서드는_범위_외의_값을_입력받는_경우_IllegalArgumentException을_던진다(int code) {
        assertThatThrownBy(() -> toCommand(code))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0과 1사이의 값을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource({"1, U", "0, D"})
    void toCommand_메서드는_0과_1사이의_값을_받아_방향에_대한_머리글자를_반환한다(int code, String result) {
        assertThat(toCommand(code)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"u", "p", "1", ""})
    void toEnum_메서드는_허용되지_않은_값을_입력받는_경우_IllegalArgumentException을_던진다(String letter) {
        assertThatThrownBy(() -> toEnum(letter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("U와 D 중 하나의 값을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource({"U, UP", "D, DOWN"})
    void toEnum_메서드는_U나_D를_입력받는_경우_Direction_인스턴스를_반환한다(String letter, Direction direction) {
        assertThat(toEnum(letter)).isEqualTo(direction);
    }

    @ParameterizedTest(name = "UP일 때 {0}를 입력받으면 {1}를 반환한다")
    @CsvSource({"UP, false", "DOWN, true"})
    void isNotSameDirection_메서드는_입력한_방향이_다른_방향인지_boolean을_반환한다(Direction direction, boolean result) {
        assertThat(UP.isNotSameDirection(direction)).isEqualTo(result);
    }
}
