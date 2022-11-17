package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ControllerCommand 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ControllerCommandTest {
    private static Stream<Arguments> generateSource() {
        return Stream.of(
                Arguments.of("R", ControllerCommand.RETRY),
                Arguments.of("Q", ControllerCommand.QUIT)
        );
    }

    @Test
    void from_메서드는_R_Q_가_아니라면_예외를_발생시킨다() {
        try {
            ControllerCommand.from(null);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("R,Q 만 입력 가능합니다");
        }
    }

    @ParameterizedTest
    @MethodSource("generateSource")
    void from_메서드는_R_Q_에_따라서_각각의_enum_을_반환합니다(String input, ControllerCommand expected) {
        assertThat(ControllerCommand.from(input)).isEqualTo(expected);
    }
}
