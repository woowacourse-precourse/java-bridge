package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("Position 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PositionTest {
    @Test
    void from_메서드는_U_D_를_받으면_해당하는_enum_을_반환한다() {
        assertThat(Position.from("U")).isEqualTo(Position.UP);
        assertThat(Position.from("D")).isEqualTo(Position.DOWN);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"A", " U", "D ", "한글"})
    void from_메서드는_U_D_를_제외한_입력을_받으면_IEA_예외가_발생한다(final String input) {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Position.from(input));
            Position.from(input);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("U,D 만 입력 가능합니다");
        }
    }
}
