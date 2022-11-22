package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CommandTest {

    @DisplayName("R과 Q가 입력되면 그에 맞는 Command를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void find(String input, Command command) {
        Command result = Command.find(input);

        assertThat(result).isEqualTo(command);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("R", Command.RETRY),
                Arguments.of("Q", Command.QUIT)
        );
    }

    @DisplayName("알맞지 않은 입력이 들어오면 예외를 발생시킨다.")
    @Test
    void findByWrongInput() {
        assertThatThrownBy(() -> Command.find("Z"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 입력입니다. R 또는 Q를 입력해주세요.");
    }
}