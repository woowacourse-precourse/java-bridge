package bridge.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    Player player = new Player(List.of("U", "U", "U"));
    Bridge bridge = new Bridge(List.of("U", "U", "U"));

    @DisplayName("플레이어가 이동할 수 있는지 판단할수있다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 플레이어_이동_가능_판단(String spaceToMove) {
        boolean moveStatus = player.move(spaceToMove);

        assertThat(moveStatus).isEqualTo(bridge.hasNextTileThatPosition(0, spaceToMove));
    }

    @DisplayName("플레이어가 이동한 결과를 저장한다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 플레이어_이동_결과_저장(String spaceToMove) {
        boolean moveStatus = player.move(spaceToMove);

        assertThat(player.getPlayResult().getPlayResult().get(0)).isEqualTo(MoveStatus.findBySpaceToMove(spaceToMove, moveStatus));
    }

    @DisplayName("플레이어의 현재 위치를 저장한다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 플레이어_위치_저장(String spaceToMove) {
        player.move(spaceToMove);

        assertThat(player)
                .extracting("position", InstanceOfAssertFactories.INTEGER)
                .isEqualTo(1);
    }

    @DisplayName("재시작시 플레이어 위치를 후진시킨다.")
    @Test
    void 재시작_시_후진() {
        player.move("U");
        player.deletePreviousPlayResult();

        assertThat(player)
                .extracting("position", InstanceOfAssertFactories.INTEGER)
                .isEqualTo(0);
    }

    @DisplayName("재시작시 이전 플레이 결과를 삭제한다.")
    @Test
    void 재시작_시_이전_플레이_결과_삭제() {
        player.move("U");
        player.deletePreviousPlayResult();

        assertThat(player.getPlayResult().getPlayResult().isEmpty()).isTrue();
    }
}