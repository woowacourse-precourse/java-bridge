package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static bridge.domain.Move.*;
import static bridge.domain.MoveResult.*;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @DisplayName("다리 이동 입력에 따른 결과 테스트")
    @MethodSource(value = "moveTestData")
    @ParameterizedTest(name = "{index}. 입력: {0}")
    public void playerMoveTest(List<Move> input, List<MoveResult> UpSideResults, List<MoveResult> DownSideResults) {
        //given
        Bridge bridge = new Bridge(List.of("U", "U", "D", "U"));
        Player player = new Player();

        //when
        for (Move move : input) {
            player.move(bridge, move);
        }

        //then
        Map<Move, List<MoveResult>> playerMoved = player.getMoveResults();
        assertThat(playerMoved.get(UP)).isEqualTo(UpSideResults);
        assertThat(playerMoved.get(DOWN)).isEqualTo(DownSideResults);
    }

    static Stream<Arguments> moveTestData() {
        return Stream.of(
                Arguments.of(
                        List.of(UP, UP, DOWN, UP),
                        List.of(SUCCESS, SUCCESS, OTHER, SUCCESS),
                        List.of(OTHER, OTHER, SUCCESS, OTHER)
                ),
                Arguments.of(
                        List.of(UP, DOWN, DOWN, UP),
                        List.of(SUCCESS, OTHER, OTHER, SUCCESS),
                        List.of(OTHER, FAIL, SUCCESS, OTHER)
                ),
                Arguments.of(
                        List.of(DOWN, UP, UP, DOWN),
                        List.of(OTHER, SUCCESS, FAIL, OTHER),
                        List.of(FAIL, OTHER, OTHER, FAIL)
                )
        );
    }
}