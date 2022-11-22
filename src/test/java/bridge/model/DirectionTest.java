package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DirectionTest {

    @DisplayName("U와 D가 입력되면 그에 맞는 Direction을 반환한다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void find(String command, Direction direction) {
        Direction result = Direction.find(command);

        assertThat(result).isEqualTo(direction);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("U", Direction.UP),
                Arguments.of("D", Direction.DOWN)
        );
    }

    @DisplayName("알맞지 않은 입력이 들어오면 예외를 발생시킨다.")
    @Test
    void findByWrongInput() {
        assertThatThrownBy(() -> Direction.find("Z"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 입력입니다. U 또는 D를 입력해주세요.");
    }
}