package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerTest {
    private static final int INITIALIZED_POSITION = -1;
    Player player;

    @DisplayName("마지막 이동 위치를 가져오는 메소드를 테스트한다.")
    @CsvSource(value = {"U:U", "D:D"}, delimiter = ':')
    void player_생성_테스트(String footprint, String expected) {
        player = new Player(List.of(footprint));
        assertThat(player.getLastMoving())
                .isEqualTo(expected);
    }

    @DisplayName("사용자 위치 초기화를 테스트한다.")
    @ParameterizedTest
    @MethodSource("generateFootprints")
    void 사용자_위치_초기화_테스트(List<String> footprints) {
        player = new Player(footprints);
        player.initializePosition();
        assertThat(player.getCurrentPosition())
                .isEqualTo(INITIALIZED_POSITION);
    }

    static Stream<Arguments> generateFootprints() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "D")),
                Arguments.of(List.of("U", "D", "U", "D")),
                Arguments.of(List.of("U", "D", "U", "D", "U")),
                Arguments.of(List.of("U", "D", "U", "D", "D"))
        );
    }
}