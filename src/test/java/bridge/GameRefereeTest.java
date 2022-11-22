package bridge;

import bridge.domain.Bridge;
import bridge.domain.GameReferee;
import bridge.domain.PlayerMoving;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRefereeTest {

    Bridge bridge = new Bridge(List.of("D", "U", "D"));
    GameReferee gameReferee = new GameReferee(bridge);

    @ParameterizedTest
    @DisplayName("이동할 수 있는 칸인지 검증한다.")
    @MethodSource("provideObjectsForIsCorrectMoving")
    void test(PlayerMoving playerMoving, int index, boolean expected) {
        assertThat(gameReferee.isCorrectMoving(playerMoving, index))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> provideObjectsForIsCorrectMoving() {
        return Stream.of(
                Arguments.of(new PlayerMoving("U"), 0, false),
                Arguments.of(new PlayerMoving("D"), 1, false),
                Arguments.of(new PlayerMoving("D"), 2, true)
        );
    }
}