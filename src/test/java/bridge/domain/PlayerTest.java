package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    final Player player = new Player();

    @DisplayName("다리 이동 입력에 따른 결과 테스트")
    @MethodSource(value = "moveTestData")
    @ParameterizedTest(name = "{index}. 입력: {0}")
    public void playerMoveTest(List<Move> input, List<MoveResult> UpSideResults, List<MoveResult> DownSideResults) {
        //given
        Bridge bridge = new Bridge(List.of("U", "U", "D", "U"));

        //when
        for (Move move : input) {
            player.move(bridge, move);
        }

        //then
        Map<Move, List<MoveResult>> playerMoved = player.getMoveResults();
        assertThat(playerMoved.get(UP)).isEqualTo(UpSideResults);
        assertThat(playerMoved.get(DOWN)).isEqualTo(DownSideResults);
    }

    @DisplayName("newLife 호출 시 플레이어 lifeCount가 1 증가한다.")
    @Test
    public void newLifePlayerLifeCountTest() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        int beforeLifeCount = player.getLifeCount();
        player.move(bridge, UP);

        player.newLife();

        assertThat(player.getLifeCount()).isEqualTo(beforeLifeCount + 1);
    }

    @DisplayName("newLife 호출 시 플레이어 moveDistance가 0으로 된다.")
    @Test
    public void newLifePlayerMoveDistanceInitTest() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        player.move(bridge, UP);
        player.move(bridge, DOWN);
        int beforeMoveDistance = player.getMoveDistance();

        player.newLife();

        assertThat(beforeMoveDistance).isEqualTo(2);
        assertThat(player.getMoveDistance()).isEqualTo(0);
    }

    @DisplayName("newLife 호출 시 플레이어의 moveResults가 초기화 된다.")
    @Test
    public void newLifePlayerMoveResultsInitTest() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        player.move(bridge, UP);
        player.move(bridge, DOWN);
        Map<Move, List<MoveResult>> beforeMoveResults = Map.copyOf(player.getMoveResults());

        player.newLife();

        assertThat(beforeMoveResults).isNotEqualTo(player.getMoveResults());
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