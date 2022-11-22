package bridge.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.enums.Direction;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("User 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserTest {

    private static final Bridge bridge = new Bridge(List.of("U", "D", "D"));
    private User user;

    private static Stream<Arguments> generateDirectionAndExpectValue() {
        return Stream.of(
                Arguments.of(Direction.UP, User.ALIVE),
                Arguments.of(Direction.DOWN, User.DEAD)
        );
    }

    @BeforeEach
    void 유저_생성() {
        user = new User();
    }

    @ParameterizedTest
    @MethodSource("generateDirectionAndExpectValue")
    void 다리_건너는_기능(Direction direction, int expected) {
        int actual = user.cross(bridge, direction);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, true", "1, false"})
    void 유저가_있는_위치_확인_기능_검사(int position, boolean expected) {
        boolean actual = user.isLocateAt(position);
        assertThat(actual).isEqualTo(expected);
    }
}
