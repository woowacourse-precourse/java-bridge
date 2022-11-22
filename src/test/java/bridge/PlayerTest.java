package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.model.Player;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    Player player;

    @BeforeEach
    void setup() {
        player = new Player();
    }

    @DisplayName("경로를 입력하면 건너는 횟수와 경로 값을 설정한다")
    @Test
    void chooseDirSuccess() {
        // given
        List<String> dirs = List.of("U", "D", "U");
        final int ONE = 1;

        // when
        dirs.forEach(player::chooseDir);

        // then
        assertThat(player.getSelectedBridge()).isEqualTo(dirs);
        assertThat(player.getNextBridge()).isEqualTo(dirs.size() - ONE);
    }

    @DisplayName("잘못된 경로를 입력하면 예외를 일으킴")
    @Test
    void chooseDirFail() {
        // given
        String dir = "S";

        // then
        assertThatThrownBy(() -> player.chooseDir(dir))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 변수를 모두 리셋시킨다")
    @Test
    void resetSuccess() {
        // given
        String dir = "U";
        int nextBridge = -1;
        List<String> selectedBridge = List.of();

        // when
        player.chooseDir(dir);
        player.reset();

        // then
        assertThat(player.getNextBridge()).isEqualTo(nextBridge);
        assertThat(player.getSelectedBridge()).isEqualTo(selectedBridge);
    }
}