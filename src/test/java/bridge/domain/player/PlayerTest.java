package bridge.domain.player;

import bridge.domain.bridge.BridgeDirection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    private Player player;

    @BeforeEach
    void init() {
        player = new Player();
    }

    @Test
    @DisplayName("사용자가 입력한 방향을 저장한다.")
    public void 사용자_방향_저장() {
        player.addMoving("U");
        player.addMoving("D");

        Assertions.assertThat(player.getTop()).isEqualTo("D");
    }

    @Test
    @DisplayName("사용자가 입력한 내역을 초기화한다")
    public void 사용자_입력_초기화() {
        player.addMoving("U");
        player.addMoving("D");

        player.clear();

        assertThatThrownBy(() -> player.getTop())
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("다리의 길이만큼 입력받으면 true를 리턴한다.")
    public void 사용자_입력_완료() {
        player.addMoving("U");
        player.addMoving("D");
        player.addMoving("D");

        Assertions.assertThat(player.isFull(3)).isTrue();
    }

    @Test
    @DisplayName("다리의 길이만큼 입력받지못했다면 false를 리턴한다.")
    public void 사용자_입력_미완료() {
        player.addMoving("U");
        player.addMoving("D");
        player.addMoving("D");

        Assertions.assertThat(player.isFull(2)).isFalse();
    }

    @Test
    @DisplayName("비교하고자 하는 방햐오가 일치하면 true를 리턴한다.")
    public void 방향_일치_테스트() {
        player.addMoving("U");
        player.addMoving("D");
        player.addMoving("D");

        Assertions.assertThat(player.equalsTop(BridgeDirection.DOWN)).isTrue();
    }

    @Test
    @DisplayName("비교하고자 하는 방햐오가 일치하지 않으면 false를 리턴한다.")
    public void 방향_불일치_테스트() {
        player.addMoving("U");
        player.addMoving("D");
        player.addMoving("D");

        Assertions.assertThat(player.equalsTop(BridgeDirection.UP)).isFalse();
    }
}
